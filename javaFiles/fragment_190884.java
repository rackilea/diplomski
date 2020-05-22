executor.schedule(new RequestProgressRunnable(), 5000, TimeUnit.MILLISECONDS);

class RequestProgressRunnable implements Runnable {
    private int count = 0;
    public void run() {
        // do stuff

        // Increment progress value
        progressValue += 10;

        // Check progress value
        if (progressValue < 100)
            executor.schedule(this, 5000, TimeUnit.MILLISECONDS);
    }
}