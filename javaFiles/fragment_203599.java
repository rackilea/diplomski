//in this case I'm using a DailyCalendar but you can use whatever implementation of Calendar you want
org.quartz.impl.calendar.DailyCalendar businessHours = new org.quartz.impl.calendar.DailyCalendar("business-hours", 8, 0, 0, 0, 16, 0, 0, 0);
businessHours.setInvertTimeRange(true);

//convert the calendar into a org.drools.time.Calendar
org.drools.time.Calendar businessHoursCalendar = QuartzHelper.quartzCalendarAdapter(businessHours);

//Register the calendar in the session with a name. You must use this name in your rules.
ksession.getCalendars().set( "business-hours", businessHoursCalendar );