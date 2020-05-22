public class CronTriggerScheduler {

    @Autowired
    private Scheduler scheduler;

    public void init(){
        scheduleJob();
    }

    private void scheduleJob() {

        try {

            JobDetail job = JobBuilder.newJob(CurrencyAddJob.class)
                    .withIdentity("DailyJobs", "group").build();

            Trigger trigger = TriggerBuilder
                    .newTrigger()
                    .withIdentity("dailyJobCronTrigger", "group")
                    .withSchedule(
                            CronScheduleBuilder.cronSchedule("0/5  * * * * ?"))
                    .build();

            scheduler.scheduleJob(job, trigger);

        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}