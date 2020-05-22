@Singleton
public class WorkerBean {

    private AtomicBoolean busy = new AtomicBoolean(false);

    @Lock(READ)
    public void doTimerWork() throws InterruptedException {

        if (!busy.compareAndSet(false, true)) {
            return;
        }

        try {
            System.out.println("Timer work started");
            Thread.sleep(12000);
            System.out.println("Timer work done");
        } finally {
            busy.set(false);
        }
    }

}