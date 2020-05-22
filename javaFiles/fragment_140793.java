class Beeper {
   public static void main(String[] args) {
      (new Beeper()).beep();
   }
   private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

   public void beep() {
       final Runnable beeper = new Runnable() {
           public void run() { 
               System.out.println("beep"); 
               try {
                   Thread.sleep(10000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       };
       final Runnable beeper2 = new Runnable() {
           public void run() {
               (new Thread(beeper)).start();
           }
       };
       final ScheduledFuture<?> beeperHandle =       scheduler.scheduleAtFixedRate(beeper2, 1, 1, SECONDS);
    }
 }