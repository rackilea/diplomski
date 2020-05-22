private void scheduleMainJob(Scheduler scheduler) throws SchedulerException {
    requireNonNull(scheduler);

    JobDetail jobDetail = newJob(MainJob.class).storeDurably()
                                               .withIdentity("MAIN_JOB")
                                               .withDescription("Main Job to Perform")
                                               .build();
    Trigger trigger = newTrigger().forJob(jobDetail)
                                  .withIdentity("MAIN_JOB_TRIGG")
                                  .withDescription("Trigger for Main Job")
                 .withSchedule(simpleSchedule().withIntervalInSeconds(15).repeatForever())
                 .startNow().build();

    scheduler.scheduleJob(jobDetail, trigger);
}