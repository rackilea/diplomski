LocalDate.of(2017, 1, 1)
    .with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, 26)
    .with(ChronoField.DAY_OF_WEEK, DayOfWeek.SUNDAY.getValue());
// 2016-07-03

LocalDate.of(2017, 1, 1).get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
// 52