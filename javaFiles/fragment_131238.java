static int dayNumberInYear(int day, Month month, int year)
    {
      if(!month.equals(Month.JANUARY)) {
        return day + dayNumberInYear(numberOfDaysInMonth(month.minus(1), year), month.minus(1), year);
      } else {
        return day;
      }
}