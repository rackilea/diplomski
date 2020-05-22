private static class MyJob implements Runnable {
   private int i;
   public MyJob(int i) {
       this.i = i;
   }
   public void run() {
       // do the thread stuff here
   }
}