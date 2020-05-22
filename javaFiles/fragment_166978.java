DateTimeFormatter f1 = new DateTimeFormatterBuilder()
    .appendPattern("yyyy[-MM[-d[ HH[:mm[:ss[.SSS]]]]]")
    .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
    .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
    .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
    .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
    .toFormatter();