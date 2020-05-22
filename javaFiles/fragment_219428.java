Thread thread = new Thread(new Runnable() {
   public void run() {
      // no-op, just return immediately
   }
});
thread.start();
thread.join();