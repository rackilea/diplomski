@Resource
 private TimerService timerService;

 @PostConstruct
 void startup() {
     ...
     for (Timer timer: timerService.getTimers()) {
         timer.cancel();
     }
     ...
 }