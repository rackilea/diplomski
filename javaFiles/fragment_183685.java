class DoSomething implements ActionListener{

  private final ScheduledExecutor scheduler = executors.newSingleThreadScheduledExecutor();
  private final long timeToRunAction;

   DoSomething(long timeToRunAction) {
     this.timeToRunAction = timeToRunAction;
   }

   public void actionPerformed(ActionEvent a)
   {
     long currentTime = System.currentTimeMillis();
     long delayTime = timeToRunAction - currentTime;
     scheduler.schedule(new Runnable() {
         public void run() { Class.doSomethingMethod(); }
     }, delayTime, TimeUnit.MILLISECONDS);
   }
}