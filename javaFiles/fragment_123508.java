Scheduler scheduler = getScheduler();
    try {
        // All scheduled jobs
        for (String groupName : scheduler.getJobGroupNames()) {
            for (JobKey jobKey : scheduler.getJobKeys(GroupMatcher.jobGroupEquals(groupName))) {
                JobDetail jobDetail = scheduler.getJobDetail(jobKey);
                final List<? extends Trigger> triggersOfJob = scheduler.getTriggersOfJob(jobKey);
                // Do something with the info you just got
                // ...
            }
        }
    } catch (SchedulerException e) {
        log.error("Retrieving jobs", e);
    }