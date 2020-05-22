final GregorianCalendar calendar = new GregorianCalendar(Locale.GERMANY);
calendar.clear();
calendar.set(Calendar.YEAR, 2012); // set to 2012
calendar.set(Calendar.WEEK_OF_YEAR, 20); // set to week number 20
calendar.set( Calendar.DAY_OF_WEEK, Calendar.MONDAY ); //set day to monday
calendar.setTimeZone(TimeZone.getTimeZone("Europe/Berlin")); // set time zone

SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy"); // german format
System.out.println(sdf.format(calendar.getTime())); // return date