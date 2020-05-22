private static DayOfWeek dayOfWeek(LocalDateTime date)  {
  return adjust(date).getDayOfWeek();
}

private static int weekBetween(LocalDateTime date1, LocalDateTime date2)  {
  int w1 = adjust(date1).get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
  if (dayOfWeek(date1).getValue() >= TUESDAY.getValue()) w1++;

  int w2 = adjust(date2).get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
  if (dayOfWeek(date2).getValue() >= TUESDAY.getValue()) w2++;

  return w2 - w1;
}

private static LocalDateTime adjust(LocalDateTime date) {
  return date.minusHours(5).minusMinutes(30);
}