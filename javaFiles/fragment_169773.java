// trigger runs every hour
 Trigger trigger = new Trigger() 
             .withIdentity("sparkJob1Trigger", "sparkJobsGroup")
             .withSchedule(
                 CronScheduleBuilder.cronSchedule("0 * * * * ?"))
             .build();


  JobDetail sparkQuartzJob = JobBuilder.newJob(SparkLauncherQuartzJob.class).withIdentity("SparkLauncherQuartzJob", "sparkJobsGroup").build();

  Scheduler scheduler = new StdSchedulerFactory().getScheduler();
  scheduler.start();
  scheduler.scheduleJob(sparkQuartzJob , trigger);