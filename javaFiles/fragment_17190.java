new Thread(new Runnable() {
  @Override
  public void run() {
    // do your fancy calculations
    unlockWaiter();
  }
}).start();

// do some stuff    
waitForThread();    
// do some stuff that is dependent on the results of the thread