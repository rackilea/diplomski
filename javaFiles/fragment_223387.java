ScheduledExecutorService ses = ...
Runnable runnable = ...

new RandomExecutor(ses, runnable, 10, 10);
new RandomExecutor(ses, runnable, 10, 10);

// run for a random length of time and wait for a random length of time, repeat.
public class RandomExecutor implements Runnable {
    private static final Random rand = new Random();
    private ScheduledExecutorService ses;
    private Runnable runnable;
    private int maxRun;
    private int maxSleep;

    public RandomExecutor(ScheduledExecutorService ses, Runnable runnable, int maxRun, int maxSleep) {
        this.ses = ses;
        this.runnable = runnable;
        this.maxRun = maxRun;
        this.maxSleep = maxSleep;
        ses.execute(this);
    }

    @Override
    public void run() {
        long end = System.currentTimeMillis() + rand.nextInt(maxRun);
        do {
            runnable.run();
        } while(end > System.currentTimeMillis());
        ses.schedule(this, rand.nextInt(maxSleep)+1, TimeUnit.MILLISECONDS);
    }
}