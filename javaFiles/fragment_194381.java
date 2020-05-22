public void execute(JobExecutionContext context) throws JobExecutionException {
    Trigger newTrigger = what_ever_you_want;
    Trigger oldTrigger = context.getTrigger();
    Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
    scheduler.rescheduleJob(oldTrigger.getKey(), newTrigger);
}