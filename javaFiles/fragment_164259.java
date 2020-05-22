public abstract class ScheduleTaskAfterRun<T> implements Runnable {
    protected void executeContent();
    private Runnable nextTask;
    private taskScheduler; // init somehow, probably by constructor...

    public void setNextTask(Runnable r) {
        nextTask = r;
    }

    @Override
    public void run() {
        executeContent();
        scheduleNextTask();
    }

    private void scheduleNextTask() {
        if(nextTask == null) {
            System.out.println("No task to handle, finished!");
            return;
        }
        Date end = new Date(Calendar.getInstance().getTimeInMillis() + 10000);
        ScheduledFuture<?> future = taskScheduler.schedule(nextTask, end);
    }
}