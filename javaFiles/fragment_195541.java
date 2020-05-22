Calendar calendar = new GregorianCalendar(Locale.GERMAN);
calendar.set(2016, Calendar.JANUARY, 1, 0, 0, 0);
Date date = calendar.getTime();

int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
int year       = calendar.getWeekYear();

System.out.println(date + " is in " + weekOfYear + " of " + year);