Timer timer = new Timer();
TimerTask task = new TimerTask() {
    @Override
    public void run() {
        // do something
    }
};
// schedule the task to be run every 100ms (0.1 sec),
// starting after "threshold" milliseconds have past
timer.schedule(task, threshold, 100);