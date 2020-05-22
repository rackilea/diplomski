public static class Worker implements Runnable {

    public enum State {
        RUNNING,
        PAUSED,
        NOT_STARTED,
        STOPPPED,
        COMPLETED;
    }

    private volatile State state = State.NOT_STARTED;

    private ReentrantLock pauseLock;
    private Condition pauseCondition;

    private JProgressBar tvpg;

    public Worker(JProgressBar tvpg) {
        pauseLock = new ReentrantLock();
        pauseCondition = pauseLock.newCondition();
        this.tvpg = tvpg;
    }

    public void pause() {
        if (state == State.RUNNING) {
            state = State.PAUSED;
        }
    }

    public void resume() {
        if (state == State.PAUSED || state == State.STOPPPED) {
            if (state == State.PAUSED) {
                state = State.RUNNING;
            }
            pauseLock.lock();
            try {
                pauseCondition.signal();
            } finally {
                pauseLock.unlock();
            }
        }
    }

    public synchronized void stop() {
        state = State.STOPPPED;
        resume();
    }

    @Override
    public void run() {

        state = State.RUNNING;
        System.out.println("Runnable has started");

        int times = 100_000;
        for (int i = 0; i < times && state != State.STOPPPED; i++) {
            checkPauseState();
            updateProgress(Math.round((i / (float) times) * 100f));
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
            }
        }

        if (state != State.STOPPPED) {
            state = State.COMPLETED;
        }

        System.out.println("Runnable has exited");

    }

    protected void checkPauseState() {
        while (state == State.PAUSED) {
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
        return state == State.PAUSED;
    }

    public boolean isRunning() {
        return state == State.RUNNING;
    }

    public boolean wasStopped() {
        return state == State.STOPPPED;
    }

    public boolean didComplete() {
        return state == State.COMPLETED;
    }

}