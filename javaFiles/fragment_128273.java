import static java.time.temporal.TemporalAdjusters.nextOrSame;

public static LocalDate getStartingDate(int year, int weekNo, DayOfWeek weekStart) {
  //should check that arguments are valid etc.
  return Year.of(year).atDay(1).with(nextOrSame(weekStart)).plusDays((weekNo - 1) * 7);
}