public class MyClass {

  protected Something myAttribute;
  protected boolean busy = true;
  protected final Object lock = new Object();

  public ReactiveLogger() {
    new Thread(new FileListener()).start();
  }

  private class FileListener implements Runnable {

    @Override
    public void run() {
      RandomAccessFile raf = new RandomAccessFile(LOG_FILE, "rw");
      while (true) {
        final String line = cutFirstLine(raf);
        if (line == null) {
          busy = false;
          synchronized (lock) {
            lock.notifyAll();
          }
          Thread.sleep(1000);
        } else {
          busy = true;
          // handeLogMessage changes myAttribute
          handleLogMessage(line);
        }
      }
    }

    // definition of cutFirstLine etc.

  }

  // definition of handleLogMessage etc.

  public Something getSomething() {
    synchronized (lock) {
      while (busy) {
        lock.wait();
      }
    }
    return myAttribute;
  }

}