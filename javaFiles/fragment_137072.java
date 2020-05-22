class MyRunnable implements Runnable {
    private Thread thisThread;
    public void run() {
       thisThread = Thread.currentThread();
       try {
          // do some work
       } catch(Throwable t) {
          t.printStackTrace(); // or log the error.
       } 
    }
    public void interrupt() {
       thisThread.interrupt();
    }
}