// calendar that excludes the 2am-3am day time range
DailyCalendar dc1 = new DailyCalendar(2,0,0,0,3,0,0,0);

// calendar that excludes the 5:30pm-5:45pm day time range
DailyCalendar dc2 = new DailyCalendar(17,30,0,0,17,45,0,0);

// combine the two calendars so that both ranges are excluded by dc2
dc2.setBaseCalendar(dc1);

// register the calendar with the scheduler
scheduler.addCalendar("MyExcludedDayTimeRangesCalendar", dc2, true, true);

MutableTrigger trigger = ... create SimpleTrigger / CronTrigger  / DailyTimeInterval / CalendarIntervalTrigger instance

// associate the created trigger with the registered calendar - the trigger will exclude calendar's time ranges  
trigger.setCalendarName("MyExcludedDayTimeRangesCalendar");

...