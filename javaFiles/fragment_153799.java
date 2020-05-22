SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy - HH:mm:ss.SSSS Z");
GregorianCalendar currentCalendar = (GregorianCalendar) Calendar.getInstance();
currentCalendar.set(Calendar.DAY_OF_MONTH, 2);
System.out.println(sdf.format(currentCalendar.getTime()));
GregorianCalendar nextSunday = (GregorianCalendar) currentCalendar.clone();
// GregorianCalendar uses Sunday as first day of week, so we must
// advance one week
int currentWeek = nextSunday.get(GregorianCalendar.WEEK_OF_YEAR);
nextSunday.set(GregorianCalendar.WEEK_OF_YEAR, currentWeek + 1);
nextSunday.set(GregorianCalendar.DAY_OF_WEEK, GregorianCalendar.SUNDAY);
nextSunday.set(GregorianCalendar.HOUR_OF_DAY, 23);
nextSunday.set(GregorianCalendar.MINUTE, 59);
nextSunday.set(GregorianCalendar.SECOND, 59);
nextSunday.set(GregorianCalendar.MILLISECOND, 0);
System.out.println(sdf.format(nextSunday.getTime()));