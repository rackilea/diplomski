@Stateless
public class TestBean implements TestLocal {

    @Resource
    TimerService timerService;

    @PostConstruct
    public void startTimer() {
        if (timerService.getTimers().size() == 0) {
            timerService.createTimer(1 * 1000, 1 * 1000, null);
        }
    }

    @Timeout
    @TransactionAttribute(value=REQUIRES_NEW)
    public void timeoutCallback(Timer timer) {
        ...
    }

}