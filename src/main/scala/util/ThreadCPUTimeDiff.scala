package util

import java.lang.management.ManagementFactory

case class ThreadCPUTimeDiff(){
    val tStart: java.lang.Long = ManagementFactory.getThreadMXBean.getCurrentThreadCpuTime / 1000000

    private var tEnd: java.lang.Long = null

    def end   = { tEnd = ManagementFactory.getThreadMXBean.getCurrentThreadCpuTime / 1000000 }

    def diffMillis: Int = (tEnd - tStart).toInt

    override def toString: String = {
      if(tEnd == null)
        throw new RuntimeException("End time of TimeDiff not specified")

      else {
         s"{{{ $diffMillis ms. }}}"
       }
    }
  }