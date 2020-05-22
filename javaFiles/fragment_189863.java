public DateOfYear theDayAfter(int day, int month, int year) {
    day++;
    int max=dayInMonth(day,month,year);
    if(day>max)
    {
        month++;
        if(month>12)
        {
            year++;
            month=1;
            day=1;
        }
    }
    return new DateOfYear(day, month, year);
}