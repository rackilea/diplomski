public static class HelloJob implements Job {
    @Override
    public void execute(JobExecutionContext ctx) throws JobExecutionException {
        System.out.println("Hello World");
    }
}

public static void main(String[] args) throws SchedulerException {
    String exp = "0 0 0 1/1 * ? *";

    SchedulerFactory factory = new StdSchedulerFactory();
    Scheduler scheduler = factory.getScheduler();
    scheduler.start();
    JobDetail job = JobBuilder.newJob(HelloJob.class).build();
    Trigger trigger = TriggerBuilder.newTrigger()
                                    .startNow()
                                    .withSchedule(
                                         CronScheduleBuilder.cronSchedule(exp))
                                    .build();
    scheduler.scheduleJob(job, trigger);
}