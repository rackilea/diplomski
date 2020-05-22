JobDetail job = newJob(SimpleJob.class)
    .withIdentity("job1", "group1")
    .build();

CronTrigger trigger = newTrigger()
    .withIdentity("trigger1", "group1")
    .withSchedule(cronSchedule("0/20 * * * * ?"))
    .build();

scheduler.scheduleJob(job, trigger);