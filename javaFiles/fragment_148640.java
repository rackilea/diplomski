Trigger trigger = newTrigger()
    .withSchedule(simpleSchedule()
        .withIntervalInMinutes(15)
        .repeatForever())
    .forJob(memoryMonitorJob)
    .build();