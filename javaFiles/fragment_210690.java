private Thread.UncaughtExceptionHandler handler = new      Thread.UncaughtExceptionHandler() {
     public void uncaughtException(Thread thread, Throwable ex) {
         Log.e("TestApplication", "Uncaught exception is: ", ex);
         // log it & phone home.
          androidDefaultUEH.uncaughtException(thread, ex);
     }
 };