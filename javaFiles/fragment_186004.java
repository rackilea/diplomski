@Test
public void test() {
  LocalDateTime tuesday_4_30 = LocalDateTime.now()
                             .with(TemporalAdjusters.next(DayOfWeek.TUESDAY))
                             .withHour(4).withMinute(30);

  LocalDateTime tuesday_6_30    = tuesday_4_30.withHour(6).withMinute(30);
  LocalDateTime previous_monday = tuesday_4_30.minusDays(1);

  // eventual adjustment using TemporalAdjusters here? like this?
  // tuesday_4_30 = tuesday_4_30.with(new MyTemporalAdjuster(DayOfWeek.TUESDAY, 5, 30));
  // <do the same for 6_30 and previous monday>
  // or possibly change some global parameter like Chronology, Locale, or such..
  assertEquals(dayOfWeek(tuesday_4_30), DayOfWeek.MONDAY);

  assertEquals(dayOfWeek(tuesday_6_30), DayOfWeek.TUESDAY);

  // there is 1 week between the previous monday and the next tuesday 6:30
  assertEquals(weekBetween(previous_monday, tuesday_6_30), 1);

  // there is 0 week between the previous monday and the next tuesday 4:30
  assertEquals(weekBetween(previous_monday, tuesday_4_30), 0);

  // 1 day between tuesday_4_30 and tuesday_6_30
  assertEquals(weekBetween(tuesday_4_30, tuesday_6_30), 1);

  // 0 day between previous_monday and tuesday_4_30
  assertEquals(weekBetween(previous_monday, tuesday_4_30), 0);
}

private static DayOfWeek dayOfWeek(LocalDateTime date)  {
  return date.atOffset(ZoneOffset.ofHoursMinutes(5, 30)).withOffsetSameInstant(UTC).getDayOfWeek();
}
private static int weekBetween(LocalDateTime date1, LocalDateTime date2)  {
  OffsetDateTime date1UTC = date1.atOffset(ZoneOffset.ofHoursMinutes(5, 30)).withOffsetSameInstant(UTC);
  OffsetDateTime date2UTC = date2.atOffset(ZoneOffset.ofHoursMinutes(5, 30)).withOffsetSameInstant(UTC);
  int w1 = date1UTC.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
  if (dayOfWeek(date1).getValue() >= TUESDAY.getValue()) w1++;

  int w2 = date2UTC.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
  if (dayOfWeek(date2).getValue() >= TUESDAY.getValue()) w2++;

  return w2 - w1;
}