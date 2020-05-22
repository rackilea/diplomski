HijriCalendar hijri =
  HijriCalendar.of(
    HijriCalendar.VARIANT_UMALQURA, 1395, HijriMonth.RAMADAN, 1); // Sunday, 1975-09-07
assertThat(
  hijri.with(HijriCalendar.WEEKDAY_IN_MONTH.setTo(3, Weekday.WEDNESDAY)),
  is(hijri.plus(17, HijriCalendar.Unit.DAYS))); // AH-1395-09-18