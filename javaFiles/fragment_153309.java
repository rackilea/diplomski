final Object someObject = ...
ExecutorService threadPool = Executors.newFixedThreadPool(10); // or whatever
threadPool.submit(new Runnable() {
  public void run() {
    synchronized (someObject) {
      someObject.wait();
    }
    // do stuff
  }
});
...
synchronized (someObject) {
  someObject.notify(); // wakes ONE waiting thread
}