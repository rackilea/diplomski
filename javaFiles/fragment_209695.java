@Singleton
@Startup
public class TriggerJob{

    @EJB
    //some injections

    @Resource
    private TimerService timerService;

    @PostConstruct
    public void init() {
        createTimer();
        //the following code resolve my startup problem
        try {
        preparation();
        } catch (CertificateVerificationException e) {
            e.printStackTrace();
        }
    }

    @Timeout
    public void timerTimeout() {
        try {
        preparation();
        } catch (CertificateVerificationException e) {
        e.printStackTrace();
        }
    }

    private void createTimer() {
        ScheduleExpression scheduleExpression = new ScheduleExpression();
        scheduleExpression.second("30").minute("*/5").hour("*");
        TimerConfig timerConfig = new TimerConfig();
        timerConfig.setPersistent(false);
        timerService.createCalendarTimer(scheduleExpression, timerConfig);
        }

    public void preparation(){
        // my scheduled tasks
    }
}