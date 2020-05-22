ExecutorService threadPool = Executors.newFixedThreadPool(10); // or whatever
threadPool.submit(new Runnable() {
  public void run() {
    // do stuff
  }
});