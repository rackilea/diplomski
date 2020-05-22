DateTime dt = new DateTime(DateTimeZone.forID("US/Eastern"));
DateTime target = dt
    .withHourOfDay(15)
    .withMinuteOfHour(0)
    .withSecondOfMinute(0)
    .withMillisOfSecond(0);

if (target.isBefore(dt)) {
  target = target.plusDays(1);
}

System.out.println(target.getMillis() - dt.getMillis());