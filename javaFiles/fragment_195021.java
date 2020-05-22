// localized week fields (using default Locale)
WeekFields weekFields = WeekFields.of(Locale.getDefault());
// equivalent to YYYY-ww
DateTimeFormatter fmt = new DateTimeFormatterBuilder()
    .appendValue(weekFields.weekBasedYear(), 4)
    .appendLiteral('-')
    .appendValue(weekFields.weekOfWeekBasedYear(), 2)
    .toFormatter();