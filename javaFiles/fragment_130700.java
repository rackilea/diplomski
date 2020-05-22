public class Worker implements Runnable {

    volatile boolean cancel = false;
    @Override
    public void run() {

        while (!cancel) {
            // Do Something here
        }
    }

    public void cancel() {
        cancel = true;
    }
}