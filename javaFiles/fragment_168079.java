LocalDate date = new LocalDate(); // note: current date in system time zone
date = date.withMonthOfYear(1); // set to January

while (date.getMonthOfYear() < 12) {
  long monthStart = date.dayOfMonth().withMinimumValue().toDateTimeAtStartOfDay().getMillis();
  long monthEnd = date.dayOfMonth().withMaximumValue().toDateTimeAtStartOfDay().getMillis();
  // store your longs in db
  date = date.plusMonths(1);
}