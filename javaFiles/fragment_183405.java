final DateFormat df = DateFormat.getDateTimeInstance();
final Calendar c = Calendar.getInstance();
StringDateUtils.clearAndSetYearToMinute(c, latestKey);
long endMillis = c.getTimeInMillis();
StringDateUtils.clearAndSetYearToMinute(c, earliestKey);
for (; c.getTimeInMillis() <= endMillis; c.add(Calendar.MINUTE, 10))
    System.out.println(df.format(c.getTime()));