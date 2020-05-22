@Singleton
public class TimerBean {

    @EJB
    private WorkerBean workerBean;

    @Lock(READ)
    @Schedule(second = "*/5", minute = "*", hour = "*", persistent = false)
    public void atSchedule() {
        workerBean.doTimerWork();
    }

}