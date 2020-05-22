class TaskScheduler {
    private ScheduledExecutorService scheduledExecutorService;

    public TaskScheduler(int threads) {
        this.scheduledExecutorService = Executors.newScheduledThreadPool(threads);
    }

    //Portion to add task
    public TaskExecutionContext schedule(String taskName, Runnable task, long initialDelay, long frequency) {
        TaskExecutionContext context = new TaskExecutionContext(taskName);
        context.getTaskResult().setFrequencyInSeconds(frequency);
        ScheduledFuture scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(task, initialDelay, frequency, TimeUnit.SECONDS);
        context.setScheduledFuture(scheduledFuture);
        return context;
    }
}

class TaskExecutionContext {
    private String taskName;
    private TaskResult taskResult;

    private ScheduledFuture scheduledFuture;

    public TaskExecutionContext(String taskName) {
        this.taskName = taskName;
        this.taskResult = new TaskResult();
        this.taskResult.setTaskName(taskName);
        this.taskResult.setStartTime(new Date());
        //DB Operation on creation
    }

    public TaskResult stop() {
        try {
            System.out.println("Stopping : " + this.taskName);
            this.taskResult.setTaskName(this.taskName);
            this.taskResult.setEndTime(new Date());
            scheduledFuture.cancel(false);
//DB Operation on stopping
            System.out.println("Stopping : finished - " + this.taskName + " @ " + new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.taskResult;
    }

    public TaskResult getTaskResult() {
        return this.taskResult;
    }

    public void setScheduledFuture(ScheduledFuture scheduledFuture) {
        this.scheduledFuture = scheduledFuture;
    }
}