static final DateTimeFormatter PARSER =
    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(
        ZoneOffset.UTC
    );
static final DateTimeFormatter PRINTER =
    DateTimeFormatter.ofPattern("MMM dd, yyyy hh:mm a", Locale.ENGLISH)
    .withZone(ZoneId.systemDefault());

public static String toLocaleZone(String utc) {
  ZonedDateTime zdt = ZonedDateTime.parse("2015-11-17 19:29:39", PARSER);      
  return PRINTER.format(zdt);
}