String expected = "Mon Jul 01 2019 00:00:00 GMT-0500 (Central Daylight Time)";
String format = "EEE MMM dd uuuu HH:mm:ss 'GMT'xx (zzzz)";

ZonedDateTime zdt = ZonedDateTime.of(2019, 7, 1, 0, 0, 0, 0, ZoneId.of("America/Chicago"));
System.out.println(zdt.format(DateTimeFormatter.ofPattern(format)));
System.out.println(expected);