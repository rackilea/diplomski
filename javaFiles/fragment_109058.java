/**
 * PauseableThread is a Thread with pause/resume and cancel methods.
 *
 * The meat of the process must implement `step`.
 *
 * You can either extend this and implement `step` or use the factory.
 *
 * I cannot extend Thread because my resume will clash.
 *
 */
public abstract class PauseableThread implements Runnable {

    // The lock.
    private final ReadWriteLock pause = new ReentrantReadWriteLock();
    private final Lock readLock = pause.readLock();
    private final Lock writeLock = pause.writeLock();
    // Flag to cancel the wholeprocess.
    private volatile boolean cancelled = false;
    // The exception that cause it to finish.
    private Exception thrown = null;
    // The thread that is me.
    private Thread me = null;

    @Override
    // The core run mechanism.
    public void run() {
        // Track my current thread.
        me = Thread.currentThread();
        try {
            while (!finished()) {
                // Block here if we're paused.
                blockIfPaused();
                // Don't do any more work if we've been asked to stop.
                if (!finished()) {
                    // Do my work.
                    step();
                }
            }
        } catch (Exception ex) {
            // Just fall out when exception is thrown.
            thrown = ex;
        }
    }

    // Have we finished yet?
    private boolean finished() {
        return cancelled || me.isInterrupted();
    }

    // Block if pause has been called without a matching resume.
    private void blockIfPaused() throws InterruptedException {
        try {
            // Grab a write lock. Will block if a read lock has been taken - i.e. we've been paused.
            writeLock.lockInterruptibly();
        } finally {
            // Release the lock immediately to avoid blocking when pause is called.
            writeLock.unlock();
        }
    }

    // Pause the work. NB: MUST be balanced by a resume.
    public void pause() {
        // We can wait for a lock here.
        readLock.lock();
    }

    // Resume the work. NB: MUST be balanced by a pause.
    public void resume() {
        // Release the lock.
        readLock.unlock();
    }

    // Stop.
    public void cancel() {
        // Stop everything.
        cancelled = true;
    }

    // Stop immediately (if param is true).
    public void cancel(boolean interrupt) {
        if (interrupt) {
            // Interrupt me.
            me.interrupt();
        } else {
            // Or cancel me.
            cancel();
        }
    }

    // Wait for completion.
    public void await() throws InterruptedException {
        // Wait 'till we've finished. NB: Will wait forever if you haven't instigated a cancel of some kind.
        while (me.isAlive()) {
            Thread.sleep(0);
        }
    }

    // Start - like a thread.
    public void start() {
        // Wrap me in a thread and fire the sucker up!
        new Thread(this).start();
    }

    // Get the exception that was thrown to stop the thread or null if the thread was cancelled.
    public Exception getThrown() {
        return thrown;
    }

    // Expose my Thread.
    public Thread getThread() {
        return me;
    }

    // Create this method to do stuff.
    // Calls to this method will stop when pause is called.
    // Any thrown exception stops the whole process.
    public abstract void step() throws Exception;

    // Factory to wrap a Stepper in a PauseableThread
    public static PauseableThread make(Stepper stepper) {
        StepperThread pauseableStepper = new StepperThread(stepper);
        // That's the thread they can pause/resume.
        return pauseableStepper;
    }

    // One of these must be used.
    public interface Stepper {

        // A Stepper has a step method.
        // Any exception thrown causes the enclosing thread to stop.
        public void step() throws Exception;
    }

    // Holder for a Stepper.
    private static class StepperThread extends PauseableThread {

        // The actual stepper I am proxying.
        private final Stepper stepper;

        StepperThread(Stepper stepper) {
            this.stepper = stepper;
        }

        @Override
        public void step() throws Exception {
            stepper.step();
        }
    }

    // !!!! Testing only below !!!!
    // My test counter.
    static int n = 0;

    // Test/demo.
    public static void main(String[] args) throws InterruptedException {

        try {
            // Simple stepper that just increments n.
            Stepper s = () -> {
                n += 1;
                Thread.sleep(1);
            };
            PauseableThread pt = PauseableThread.make(s);
            // Start it up.
            pt.start();
            Thread.sleep(1000);
            pt.pause();
            System.out.println("Paused: " + n);
            Thread.sleep(1000);
            System.out.println("Resuminng: " + n);
            pt.resume();
            Thread.sleep(1000);
            pt.cancel();
            pt.await();
            System.out.println("Finished: " + n);

            // Start again to test agressive cancelling.
            n = 0;
            pt = PauseableThread.make(s);
            // Start it up.
            pt.start();
            Thread.sleep(1000);
            pt.pause();
            System.out.println("Paused: " + n);
            Thread.sleep(1000);
            System.out.println("Resuminng: " + n);
            pt.resume();
            Thread.sleep(1000);
            // Cancel aggressively.
            pt.cancel(true);
            System.out.println("Finished: " + n);
            System.out.println("thrown: " + pt.getThrown());

        } catch (InterruptedException e) {
        }
    }
}