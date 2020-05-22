static final DateTimeFormatter PARSER =
    DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").withZoneUTC();
static final DateTimeFormatter PRINTER =
    DateTimeFormat.forPattern("MMM dd, yyyy hh:mm a").withLocale(Locale.ENGLISH).withZone(
        DateTimeZone.getDefault()
    );

public static String toLocaleZone(String utc) {
  DateTime dt = PARSER.parseDateTime("2015-11-17 19:29:39");
  return PRINTER.print(dt);
}