String DATE_TIME_FORMAT_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";
DateTimeFormatter formatter1 = new DateTimeFormatterBuilder()
    .appendPattern(DATE_TIME_FORMAT_PATTERN)
    // optional decimal point followed by 1 to 6 digits
    .optionalStart()
    .appendPattern(".")
    .appendFraction(ChronoField.MICRO_OF_SECOND, 1, 6, false)
    .optionalEnd()
    .toFormatter();