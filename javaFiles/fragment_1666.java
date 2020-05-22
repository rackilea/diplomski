@Singleton
public class TimerBean {

    @Schedule(second= "*/5", minute = "*", hour = "*", persistent = false)
    public void atSchedule() throws InterruptedException {

        System.out.println("Called");
        Thread.sleep(10000);
    }
}