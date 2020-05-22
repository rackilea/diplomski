public class Worker implements Runnable {
    //...
    private AtomicBoolean keepRunning;

    public Worker(JProgressBar tvpg) {
        //...
        keepRunning = new AtomicBoolean(true);
        //...
    }
    //...

    public synchronized void stop() {
        keepRunning.set(false);
        // Make sure the thread isn't currently
        // paused, otherwise it will never exit...
        resume();
    }

    //...

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