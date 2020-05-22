public static void main(String[] args) {
   ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
   executor.scheduleWithFixedDelay(new Thr(), 0, 1, TimeUnit.SECONDS);
}

public static class Thr implements Runnable {

   @Override
   public void run() {
      try {
         Thread.sleep(TimeUnit.SECONDS.toMillis(10));
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      System.out.println("Hi");
   }
}