@Singleton
public class WorkerBean {

    @AccessTimeout(0)
    public void doTimerWork() throws InterruptedException {
        System.out.println("Timer work started");
        Thread.sleep(12000);
        System.out.println("Timer work done");
    }
}