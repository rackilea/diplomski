Calendar cal = Calendar.getInstance();
cal.set(year, month, day, hourOfDay, minute);
long exact_alarm_time = cal.getTimeInMillis();

// if user want to set before 10 minutes
long before = 10*60*1000;

// now subtract the before time from current time
long newTime = exact_alarm_time - before;

Calendar cNew = Calendar.getInstance();
cal.setTimeInMillis(newTime);
int year = cal.get(Calendar.YEAR);
int month = cal.get(Calendar.MONTH);
int date = cal.get(Calendar.DATE);
int min = cal.get(Calendar.MINUTE);
int hour = cal.get(Calendar.HOUR);

// now set alarm for the new time