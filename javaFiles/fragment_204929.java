@Stateless
public class JobSchedulerBean {
    @Resource
    private TimerService timerService;

    // @PostConstruct
    public void initTimer() {
        // set initial timer
        ScheduleExpression sch = new ScheduleExpression();
        // set cron expression into sch
        timerService.createCalendarTimer(sch, new TimerConfig("myTimer", false));
    }

    public void rescheduleTimer(int interval) {
        // get timer from timer service
        for (Timer timer : timerService.getTimers()) {
            if (timer != null && timer.getInfo().equals("myTimer")) {
                timer.cancel();
            }
        }
        // schedule new timer, like in initTimer() method
    }

    @Timeout
    public void timeout(Timer timer) {
        // do the job
    }
}