// We know week number and year.
int week = 3;
int year = 2010;

// Get calendar, clear it and set week number and year.
Calendar calendar = Calendar.getInstance();
calendar.clear();
calendar.set(Calendar.WEEK_OF_YEAR, week);
calendar.set(Calendar.YEAR, year);

// Now get the first day of week.
Date date = calendar.getTime();