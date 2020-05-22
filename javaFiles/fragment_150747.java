// obviously we should implement Runnable here
  public class MyThread extends Thread {
      public MyThread() {
         ...
         // very bad idea because the constructor may not have finished
         this.start();
      }
  }