DateTimeFormatter fmt = new DateTimeFormatterBuilder()
    // case insensitive for month name in all caps
    .parseCaseInsensitive()
    // date/time pattern
    .appendPattern("dd-MMM-yy HH:mm:ss")
    // use English locale for month name
    .toFormatter(Locale.ENGLISH)
    // set a timezone
    .withZone(ZoneId.of("Europe/London"));
// parse the dates
ZonedDateTime z1 = ZonedDateTime.parse("01-SEP-17 10:00:00", fmt);
ZonedDateTime z2 = ZonedDateTime.parse("05-SEP-17 12:00:00", fmt);
// calculate the difference in hours
long diffHours = ChronoUnit.HOURS.between(z1, z2);