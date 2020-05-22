// in this case, the formatter doesn't need the default values
YearMonth ym = YearMonth.parse("Mayo 2017", fmt);
ZonedDateTime z = ym
    // set day of month to 1
    .atDay(1)
    // midnight at JVM default timezone
    .atStartOfDay(ZoneId.systemDefault());
Date javaUtilDate = date.from(z.toInstant());