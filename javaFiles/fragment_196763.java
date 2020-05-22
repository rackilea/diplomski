@Startup
   @Singleton
   public class SchedulerBean {
     @Resource
     private TimerService timerService;
     @EJB
     private LoaderManager loaderManager;
     private Timer timer;

     @PostConstruct
     public void init() {
       timer = timerService.createIntervalTimer(20 * 1000, 20 * 1000, new TimerConfig(null, false));
     }

     @PreDestroy
     public void deinit() {
       timer.cancel();
     }

     @Timeout
     public void schedule(Timer timer) {
        // TODO: Add your checks here
        loaderManager.loadDatabase(databaseLocation);
     }
   }