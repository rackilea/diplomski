for (String timeZone : timeZones) {
  TimeZone tz = TimeZone.getTimeZone(timeZone);

  long hours = TimeUnit.MILLISECONDS.toHours(tz.getRawOffset());
  long minutes = TimeUnit.MILLISECONDS.toMinutes(tz.getRawOffset())
      - TimeUnit.HOURS.toMinutes(hours);

  String timeZoneString = String.format("( GMT %d:%02d ) %s(%s)", hours,
      minutes, tz.getDisplayName(), timeZone);
  tzList.add(timeZoneString);
  System.out.println(timeZoneString);
}