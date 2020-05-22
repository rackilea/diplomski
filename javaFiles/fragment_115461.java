int daysExcludingLeapYearDay(Date start, Date end)
{
    if(end.isBefore(start))
    {
        return filterOutLeapYearDays(daysBetween(end, start)).size();
    }

    return filterOutLeapYearDays(daysBetween(start, end)).size();
}

List<Date> filterOutLeapYearDays(List<Date> days)
{
    List<Date> daysExcludingLeapYearDays = 
             days
             .filter(d -> !isFeb29(d))
             .toList());

    return daysExcludingLeapYearDays;
}

List<Date> daysBetween(Date start, Date end) 
{
    List<Date> days = new List();

    for (Date day = start; day.isBefore(end); day = day.plusOneDay()) 
    {
        days.add(day);
    }

    return days
}

boolean isFeb29(Date date) 
{
    return date.month == FEBRUARY && date.day == 29;
}