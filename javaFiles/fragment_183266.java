DateTimeFormatter fmt = new DateTimeFormatterBuilder()
    // case insensitive
    .parseCaseInsensitive()
    // pattern with full month name (MMMM)
    .appendPattern("MMMM yyyy")
    // default value for day of month
    .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
    // default value for hour
    .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
    // default value for minute
    .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
    // set locale
    .toFormatter(new Locale("es", "ES"));