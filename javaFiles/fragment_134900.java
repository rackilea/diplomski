private Target target;  // this is a Spring bean of some kind
@Autowired private TaskScheduler taskScheduler;

public void scheduleSomething() {
    Runnable task = new Runnable() {
       public void run() {
          target.doTheWork();
       }
    };
    taskScheduler.scheduleWithFixedDelay(task, delay);
}