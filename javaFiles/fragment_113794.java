Calendar calendar = Calendar.getInstance();
TimeZone fromTimeZone = calendar.getTimeZone();
TimeZone toTimeZone = TimeZone.getTimeZone("CST");

calendar.setTimeZone(fromTimeZone);
calendar.add(Calendar.MILLISECOND, fromTimeZone.getRawOffset() * -1);
if (fromTimeZone.inDaylightTime(calendar.getTime())) {
    calendar.add(Calendar.MILLISECOND, calendar.getTimeZone().getDSTSavings() * -1);
}

calendar.add(Calendar.MILLISECOND, toTimeZone.getRawOffset());
if (toTimeZone.inDaylightTime(calendar.getTime())) {
    calendar.add(Calendar.MILLISECOND, toTimeZone.getDSTSavings());
}

System.out.println(calendar.getTime());