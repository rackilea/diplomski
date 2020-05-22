public class MyAbortableRunnable implements Runnable {
    private final Object lock = new Object();
    private AbortableHttpRequest request;

    public void abort() {
        synchronized(lock) {
            if (request != null) {
                request.abort();
            }
        }
    }

    @Override
    public void run() {
        ...
        // create the request
        synchronized(lock) {
            this.request = ...;
        }
        ...
    }
}