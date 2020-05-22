public class MyQuartzScheduler {
    public static void main( String[] args ) throws Exception {
        JobDetail job = JobBuilder.newJob(MyJob.class)
        .withIdentity("dummyJobName", "group1").build();

        Trigger trigger = TriggerBuilder
        .newTrigger()
        .withIdentity("MyJobTrigger", "group1")
        .withSchedule(
            CronScheduleBuilder.cronSchedule("0 * * * * ?"))
        .build();

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);
    }
}