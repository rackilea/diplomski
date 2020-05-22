// get any zone, just to get a valid ZoneId
ZoneId zone = ZoneId.of("Europe/London");
// change ID to empty string (so it's not printed by the formatter)
Field field = zone.getClass().getDeclaredField("id");
field.setAccessible(true);
field.set(zone, "");
// change zone rules to match UTC (so this zone becomes a "copy" of UTC)
field = zone.getClass().getDeclaredField("rules");
field.setAccessible(true);
field.set(zone, ZoneOffset.UTC.getRules());

DateTimeFormatter dtf = new DateTimeFormatterBuilder()
    // date and time
    .appendPattern("yyyy-MM-dd'T'HH:mm:ss.SSS")
    // optional offset - prints +0000 when it's zero (instead of Z)
    .optionalStart().appendOffset("+HHMM", "+0000").optionalEnd()
    // optional zone id (so it parses "Z")
    .optionalStart()
    .appendZoneId()
    // add default value for offset seconds when field is not present
    .parseDefaulting(ChronoField.OFFSET_SECONDS, 0)
    .optionalEnd()
    // create formatter using the "UTC-cloned" zone
    .toFormatter().withZone(zone);

System.out.println(dtf.format(ZonedDateTime.now()));
System.out.println(dtf.format(Instant.now()));

String dateStringOffset = "2017-07-13T21:20:33.123+0200";
System.out.println(dtf.parse(dateStringOffset));

String dateStringZulu = "2017-07-13T21:20:33.123Z";
System.out.println(dtf.parse(dateStringZulu));