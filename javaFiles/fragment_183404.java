final DateFormat df = DateFormat.getDateTimeInstance();
final Calendar c = Calendar.getInstance();
c.clear();
c.set(StringDateUtils.getYear(latestKey),
      StringDateUtils.getMonth(latestKey) - 1, 
      StringDateUtils.getDayOfMonth(latestKey),
      StringDateUtils.getHourOfDay(latestKey),
      StringDateUtils.getMinuteOfHour(latestKey));
long endMillis = c.getTimeInMillis();
c.clear();
c.set(StringDateUtils.getYear(earliestKey),
      StringDateUtils.getMonth(earliestKey) - 1,
      StringDateUtils.getDayOfMonth(earliestKey),
      StringDateUtils.getHourOfDay(earliestKey),
      StringDateUtils.getMinuteOfHour(earliestKey));
for (; c.getTimeInMillis() <= endMillis; c.add(Calendar.MINUTE, 10))
    System.out.println(df.format(c.getTime()));