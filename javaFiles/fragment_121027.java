DateTimeFormatter DATE_FORMATTER = new DateTimeFormatterBuilder()
    .appendOptional(DateTimeFormat.forPattern("yyyy-MM-dd").getParser())
    .appendOptional(DateTimeFormat.forPattern("MM/dd/yy").getParser())
    .appendOptional(DateTimeFormat.forPattern("MMM dd, yyyy").getParser())
    // use English locale
    .toFormatter().withLocale(Locale.ENGLISH);