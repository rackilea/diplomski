PlainDate input = 
  SystemClock.inLocalView().today(); // using system timezone
Weekday weekday = Weekday.SUNDAY;

PlainDate adjusted = 
  input.with(PlainDate.WEEKDAY_IN_MONTH.setToThird(weekday));
boolean isThirdSundayInMonth = input.equals(adjusted);