static final ChronoFormatter<Moment> PARSER =
    ChronoFormatter.ofMomentPattern(
        "yyyy-MM-dd HH:mm:ss",
        PatternType.CLDR,
        Locale.ROOT,
        ZonalOffset.UTC
    );
static final ChronoFormatter<PlainTimestamp> PRINTER =
    ChronoFormatter.ofTimestampPattern(
        "MMM dd, yyyy hh:mm a",
        PatternType.CLDR,
        Locale.ENGLISH
    );

public static String toLocaleZone(String utc) throws ParseException {
  Moment m = PARSER.parse(utc); // "2015-11-17 19:29:39"
  return PRINTER.format(m.toLocalTimestamp()); // Nov 17, 2015 08:29 pm
}