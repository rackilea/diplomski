@ManagedBean(eager=true)
@ApplicationScoped
public class JobRunner {
    private ScheduledExecutorService scheduler;
    private static final int POOL_SIZE = 1;

    ScheduledFuture<?> runHandle;

    @PostConstruct
    public void init() {
        scheduler = Executors.newScheduledThreadPool(POOL_SIZE);
        // set initial expiry to 5 minutes after 5 minutes delay
        runHandle = scheduler.scheduleAtFixedRate(new MyJob(), 5, 5, TimeUnit.MINUTES);
    }

    @PreDestroy
    public void destroy() {
        scheduler.shutdownNow();
    }

    public void reschedule(int newDelay) {
        // cancel old timer, but do not interrupt it
        runHandle.cancel(false);
        runHandle = scheduler.scheduleAtFixedRate(new MyJob(), newDelay, newDelay, TimeUnit.MINUTES);
    }
}

public class MyJob implements Runnable {
    public void run() { 
        // do the job
    }
}