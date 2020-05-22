// Assume we've already done all the parsing
int dayOfWeek = parsedCalendar.get(Calendar.DAY_OF_WEEK);

long now = System.currentTimeMillis();
Calendar currentCalendar = Calendar.getInstance();
currentCalendar.setTimeInMillis(now);
currentCalendar.set(Calendar.DAY_OF_WEEK, dayOfWeek);
if (currentCalendar.getTimeInMillis() < now) {
    currentCalendar.add(Calendar.DAY_OF_MONTH, 7);
}