int daysInMonthReminder = dayInMonth%7;

  if(daysInMonthReminder >= dayInWeek) {

    daysInMonthReminder = daysInMonthReminder - dayInWeek;

    dayInWeek = 7;

}

return ((dayInWeek - daysInMonthReminder)%7) + 1;