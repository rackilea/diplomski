Month month = Month.monthWithNumber(monthNumber);
if (month.isLegalDay(dayNumber)) {
    ....
    if (month.isLastDayInMonth(dayNumber)) {
        nextMonth = month.nextMonth().getName();
        nextDay = 0;
    }
}