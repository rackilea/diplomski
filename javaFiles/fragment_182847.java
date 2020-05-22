LocalDate input = LocalDate.now(); // using system timezone
int ordinal = 3;
DayOfWeek weekday = DayOfWeek.SUNDAY;

LocalDate adjusted = 
  input.with(TemporalAdjusters.dayOfWeekInMonth(ordinal, weekday));
boolean isThirdSundayInMonth = input.equals(adjusted);