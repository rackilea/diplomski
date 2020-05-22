String timestamp = "2018-12-18 16:00:28";
String zone = "EDT";
String timeWithZone = timestamp + ' ' + zone;

DateTimeFormatter formatter = new DateTimeFormatterBuilder()
    .append(DateTimeFormatter.ISO_LOCAL_DATE)
    .appendLiteral(' ')
    .append(DateTimeFormatter.ISO_LOCAL_TIME)
    .appendLiteral(' ')
    .appendPattern("z") // Zone
    .toFormatter();

ZonedDateTime edt = ZonedDateTime.parse(timeWithZone, formatter);
ZonedDateTime utc = edt.withZoneSameInstant(ZoneId.of("UTC"));