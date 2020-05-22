// parse the input
ZonedDateTime parsed = ZonedDateTime.parse("2017-08-02T06:05:30.000Z");
// convert to another timezone
ZonedDateTime z = parsed.withZoneSameInstant(ZoneId.of("Asia/Kolkata"));
// format output
DateTimeFormatter fmt = DateTimeFormatter.ofPattern("hh:mm a", Locale.ENGLISH);
System.out.println(fmt.format(z));