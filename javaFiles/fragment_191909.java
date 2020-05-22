public class Worker implements Runnable {

    private ReentrantLock pauseLock;
    private Condition pauseCondition;
    private AtomicBoolean paused;
    private AtomicBoolean keepRunning;

    private JProgressBar tvpg;

    public Worker(JProgressBar tvpg) {
        paused = new AtomicBoolean();
        keepRunning = new AtomicBoolean(true);
        pauseLock = new ReentrantLock();
        pauseCondition = pauseLock.newCondition();
        this.tvpg = tvpg;
    }

    public void pause() {
        paused.set(true);
    }

    public void resume() {
        paused.set(false);
        pauseLock.lock();
        try {
            pauseCondition.signal();
        } finally {
            pauseLock.unlock();
        }
    }

    public synchronized void stop() {
        keepRunning.set(false);
        resume();
    }

    @Override
    public void run() {

        System.out.println("Runnable has started");

        int times = 100_000;
        int i = 0;
        while (i < times && keepRunning.get()) {
            checkPauseState();
            updateProgress(Math.round((i / (float) times) * 100f));
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
            }
            i++;
        }

        System.out.println("Runnable has exited");

    }

    protected void checkPauseState() {
        while (paused.get()) {
            pauseLock.lock();
            try {
                pauseCondition.await();

            } catch (Exception e) {
            } finally {
                pauseLock.unlock();
            }
        }
    }

    protected void updateProgress(int progress) {
        if (EventQueue.isDispatchThread()) {
            tvpg.setValue(progress);
        } else {
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    updateProgress(progress);
                }
            });
        }
    }

    public boolean isPaused() {
        return paused.get();
    }

}