CronTrigger trigger = new CronTrigger();
    trigger.setName("dummyTriggerName");
    // fetch the value from DB here and create the CRON string accordingly
    final String cronString = "0 " + value fetched from DB + " 10 * * ?"
    trigger.setCronExpression(cronString );


Scheduler scheduler = new StdSchedulerFactory().getScheduler();
    scheduler.start();
    scheduler.scheduleJob(job, trigger);