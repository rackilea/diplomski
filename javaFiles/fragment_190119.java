public void run() {
   while(doWork) {
      ...
      // if task finished set doWork to false
   }

   // signal main thread that I've finished
   synchronized(locker) {
      activeThreads.getAndDecrement();
      locker.notify();
   }
}