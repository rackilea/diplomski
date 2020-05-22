// retrieve the old trigger
Trigger oldTrigger = sched.getTrigger(triggerKey("oldTrigger", "group1");

// obtain a builder that would produce the trigger
TriggerBuilder tb = oldTrigger.getTriggerBuilder();

// update the schedule associated with the builder, and build the new trigger
Trigger newTrigger = tb
    .withSchedule(cronSchedule(yourCronExpression))
    .startAt(DateBuilder.tomorrowAt(3,0,0))
    .build();

// tell the scheduler to remove the old trigger with the given key, and put the new one in its place
sched.rescheduleJob(oldTrigger.getKey(), newTrigger);