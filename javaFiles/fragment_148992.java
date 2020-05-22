public class MyWorkerThread implements Runnable {
  private boolean run = true;

  public void run() {
    while (run) {
      // Do work here...
    }

    // Do any thread cooldown procedures here, like stop listening to the Queue.
  }

  public void setRunning(boolean runState) {
    run = runState;
  }
}