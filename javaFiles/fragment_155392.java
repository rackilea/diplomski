class MyThread2 implements Runnable {
   private static final Object lock = new Object();
   ...
   public void run() {
     synchronized(lock) {
       ...
     }
   }
}