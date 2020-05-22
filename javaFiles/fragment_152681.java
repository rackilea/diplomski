// A real life example
class MyDate
{
    // Create a date structure from a day of the year (1..366)
    MyDate(int dayOfTheYear, int year)
    {
        if (dayOfTheYear < 1 || dayOfTheYear > 366)
        {
            mDateValid = false;
            return;
        }
        if (dayOfTheYear == 366 && !isLeapYear(year))
        {
            mDateValid = false;
            return;
        }
        // Continue converting dayOfTheYear to a dd/mm.
        // ...