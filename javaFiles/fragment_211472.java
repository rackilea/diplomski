import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

aspect Profiler {
  pointcut mainStarting(): execution(public static void main(..));
  pointcut mainEnding(): execution(public static void main(..));
  pointcut methodCallBegin(): (call(* *.a (..)) || call(* *.println (..)));
  pointcut methodCallEnd(): (call(* *.a (..)) || call(* *.println (..)));

  static ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
  double getTime() {
       return (threadBean.getCurrentThreadCpuTime() / 1000000.0);
  }
  before(): mainStarting() {
       System.out.print("mainStarting: "+Thread.currentThread().getId() 
             + " " + getTime()+"\n");
  }

  after(): mainEnding() {
       System.out.print("mainEnding: "+Thread.currentThread().getId() 
             + " " + getTime()+"\n");
  }

  before(): methodCallBegin() {
      System.out.print("methodCallBegin: "+Thread.currentThread().getId() 
             + " " + getTime()+"\n");
  }

  after(): methodCallEnd() {
      System.out.print("methodCallEnd: "+Thread.currentThread().getId() 
             + " " + getTime()+"\n");
  }
}