public class MyRunnable implements Runnable {
    private final AtomicBoolean stopFlag;

    public MyRunnable(AtomicBoolean stopFlag) {
        this.stopFlag = stopFlag;
    }

    @Override
    public void run() {
        try { // Try/Catch only needed if you use locks/sleep etc.
            while (!stopFlag.get()) {
                // Do some work, but remember to check flag often!
            }
        }
        catch (InterruptedException e) {  
            // Interrupted, no need to check flag, just exit
            return;
        }
    }
}