public class MyThread extends Thread {
   private boolean aborted = false;
   private final Object sleepingControl=new Object();

   //... other unrelated stuff...

   private void delay() {
      try {
          synchronized(sleepingControl) {
             sleepingControl.wait(delay);

             if (!aborted)
                 delayFinished();
          }
      } catch (InterruptedException e) {
      }
    }
    public void abortDelay() {
          synchronized(sleepingControl) {
             aborted = true;
             sleepingControl.notify();
          }
    }
 }