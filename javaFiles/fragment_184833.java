long durationMillis = 26 * 3600 * 1000;
Period period = new Period(durationMillis, PeriodType.dayTime(),
    ISOChronology.getInstanceUTC());
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ this is needed to have 1 day == 24 hours
// this works!
assertEquals(1, period.getDays());
// this works!
assertEquals(2, period.getHours());