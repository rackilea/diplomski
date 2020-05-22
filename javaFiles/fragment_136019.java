protected final Timer timer = new Timer();

public void execute() {
   CountDownLatch latch = new CountDownLatch(1);
   timer.schedule(new TimerTask() {
       public void run() {
       }
   }, delayBeforeStart);
   try {
       latch.await();
   } catch (InterruptedException e) {
       log(e);
   }
   timer.cancel();
}