@Singleton
...
public TimerMangerbean implements TimerManager {

   @Resource
   private TimerService timerService;

   public void startMonitoring() {
      //start in 5 sec and timeout every 10 minutes
      Timer timer = timerService.createTimer(5000, 60000, "MyTimer");
   }

   public void stopMonitoring() {
      Collection<Timer> timers = timerService.getTimers();
      for(Timer timer : timers) {
         //look for your timer
         if("MyTimer".equals(timer.getInfo())) {
            timer.cancel();break;
         }
      }
   }

   //called every 10 minutes
   @Timeout
   public void onTimeout() {
      //verify the condition and do your processing
   }
}