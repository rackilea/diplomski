TriggerBuilder
        .newTrigger()
        .withIdentity("dummyTriggerName", "group1")
        .forJob(job)//<--- this line is the new addition
        .withSchedule(
         CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).build();