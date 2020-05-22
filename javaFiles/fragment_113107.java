DateTimeFormatter parser = new DateTimeFormatterBuilder()
    // optional ISO8601 date/time and offset
    .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
    // optional yyyy-MM-dd or yyyyT or yyyyMMT
    .appendPattern("[yyyy-MM-dd][yyyy'T'][yyyyMM'T']")
    // default day is 1
    .parseDefaulting(ChronoField.DAY_OF_MONTH, 1L)
    // default month is January
    .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1L)
    // create formatter
    .toFormatter();