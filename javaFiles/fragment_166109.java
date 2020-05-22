DateTimeFormatter fmt = new DateTimeFormatterBuilder()
  .appendPattern("yyyy-MM-dd'T'HH:mm:ss.SSS")
  // offset, use "-00:00" when it's zero
  .appendOffset("+HH:MM", "-00:00")
  // create formatter, always work in UTC
  .toFormatter().withZone(ZoneOffset.UTC);
String dateStringToConvert = "2016-03-12T22:00:00.000-00:00";
Instant instant = fmt.parse(dateStringToConvert, Instant::from);
String result = fmt.format(instant);
System.out.println(result);