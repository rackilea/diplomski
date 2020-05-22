JobBuilder job = newJob(ServerMonitorJob.class);

TriggerBuilder trigger = newTrigger()
        .withSchedule(
            simpleSchedule()
                .withIntervalInMinutes(15)
        );


scheduler.scheduleJob(job.build(), trigger.build());