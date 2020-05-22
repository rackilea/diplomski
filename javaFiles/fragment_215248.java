@Service
public class DynamicJob {

    public void schedule(TestScript testScript) {
        try {
            JobDetail job = JobBuilder.newJob(TestScript.class)
                    .withIdentity(testScript.getName(), "default group")
                    .build();

            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity(testScript.getName().concat(" trigger"), "groupAll")
                    .withSchedule(CronScheduleBuilder.cronSchedule(testScript.getCronExpression()))
                    .build();

            Scheduler scheduler = new StdSchedulerFactory().getScheduler();
            scheduler.start();
            scheduler.scheduleJob(job, trigger);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}