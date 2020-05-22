Date start = 12/20/2012;
Date endDate = 12/31/2017;
SimpleTrigger trigger = newTrigger()
    .withIdentity("trigger3", "group1")
    .startAt(startDate) 
    .withSchedule(cronSchedule("* * 17 0/3 * *").build())
    .endAt(endDate)
    .build;