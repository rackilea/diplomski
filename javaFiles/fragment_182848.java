LocalDate input = new LocalDate(); // using system timezone
int ordinal = 3;
int weekday = DateTimeConstants.SUNDAY;

LocalDate start = new LocalDate(input.getYear(), input.getMonthOfYear(), 1);
LocalDate date = start.withDayOfWeek(weekday);
LocalDate adjusted = (
  date.isBefore(start)) 
  ? date.plusWeeks(ordinal) 
  : date.plusWeeks(ordinal - 1);
boolean isThirdSundayInMonth = input.equals(adjusted);