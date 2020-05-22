static int dayNumberInYearByLoop(int day, Month month, int year) {
  int totalDays = day;
  for (int i = month.getValue();i>1;i--) {
    totalDays += numberOfDaysInMonth(Month.of(i), year);
  }
  return totalDays;
}