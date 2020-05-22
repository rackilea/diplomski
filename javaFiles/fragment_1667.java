@Singleton
public class TimerBean {

    @EJB
    private WorkerBean workerBean;

    @Lock(READ)
    @Schedule(second = "*/5", minute = "*", hour = "*", persistent = false)
    public void atSchedule() {

        try {
            workerBean.doTimerWork();
        } catch (Exception e) {
            System.out.println("Timer still busy");
        }
    }

}