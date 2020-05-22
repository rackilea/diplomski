Timer timer = new Timer();
TimerTask task = new TimerTask() {
    private final long start = System.currentTimeMillis();
    @Override
    public void run() {
        if (System.currentTimeMillis() - start < threshold) {
            // do something
        } else {
            // do something else
        }
    }
};
// schedule the task to be run every 100ms (0.1 sec), starting immediately
timer.schedule(task, 0, 100);