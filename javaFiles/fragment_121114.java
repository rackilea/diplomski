Trigger trigger = TriggerBuilder
    .newTrigger()
    .withIdentity("someTriggerName", "someGroup")
    .withSchedule(
        CronScheduleBuilder.cronSchedule("0 5,15,30 * * * ?"))
    .build();