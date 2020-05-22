public class Main{

   public static void main(final String[] args) {
      someMethod();
   }

   public static void someMethod() {
      log("hello from someMethod");
      //do stuff
   }

   public static void log(final String msg) {
      final String threadname = Thread.currentThread().getName();
      System.out.println( "[" + threadname + "] " + msg );
   }
}