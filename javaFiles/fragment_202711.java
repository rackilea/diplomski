Thread th = new Thread(new Runnable() {
  public void run() {
    throw new NullPointerException();
  }
});
th.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
  public void uncaughtException(Thread thread, Throwable throwable) {
    // This gets run because the NPE ends the child thread.
    System.err.println("Uncaught " + throwable);
  } 
});
try {
  th.start();
} catch (NullPointerException ex) {
  System.err.println("Not reached");
}