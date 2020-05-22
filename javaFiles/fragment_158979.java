public void run() {

   try {
      while(!Thread.currentThread().isInterrupted()) {
         // ...
      }
   } catch (InterruptedException consumed)
      /* Allow thread to exit */
   }

}

public void cancel() { interrupt(); }