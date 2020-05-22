// prefered zones
Set<ZoneId> preferredZones = new HashSet<>();
preferredZones.add(ZoneId.of("America/New_York"));

DateTimeFormatter fmt = new DateTimeFormatterBuilder()
    // date and time
    .appendPattern("MMM dd, yyyy, h:mm a ")
    // zone (use set of prefered zones)
    .appendZoneText(TextStyle.SHORT, preferredZones)
    // create formatter (use English locale for month name)
    .toFormatter(Locale.ENGLISH);
String dateString = "Aug 15, 2017, 4:58 PM ET";
// parse string
ZonedDateTime zdt = ZonedDateTime.parse(dateString, fmt);
// convert to java.util.Date
Date date = Date.from(zdt.toInstant());