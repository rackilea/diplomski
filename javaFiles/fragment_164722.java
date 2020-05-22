public class PrintStreamWrapper extends PrintStream {
    public PrintStreamWrapper(OutputStream out) {
       super(out);
    }

    public void println(String x) {
         StackTraceElement[] trace = Thread.currentThread().getStackTrace();
         // print everything, but not to the System.out, 
         // because you'll end up in a loop.
         super.println(x);
    }   
}