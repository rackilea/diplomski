// array with all possible patterns
DateTimeParser[] parsers = new DateTimeParser[] {
    DateTimeFormat.forPattern("yyyy-MM-dd").getParser(),
    DateTimeFormat.forPattern("MM/dd/yy").getParser(),
    DateTimeFormat.forPattern("MMM dd, yyyy").getParser() };

DateTimeFormatter DATE_FORMATTER = new DateTimeFormatterBuilder()
    // use array of all possible parsers
    .append(null, parsers)
    // use English locale
    .toFormatter().withLocale(Locale.ENGLISH);