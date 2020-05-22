public static int numberOfDaysBeforeMonth(int monthNumber, boolean leapYear)
{
    //if monthNumber is out of range, return -1
    if(monthNumber< 1 || monthNumber > 12)
         return -1;

    int[] daysPerMonth= {31,28,31,30,31,30,31,31,30,31,30,31};

    int numberOfDays = 0;

    //add up the days in the months preceding the month in question
    for (int month = 1; month < monthNumber; month++)
       numberOfDays += daysPerMonth[month - 1];

    //add an extra day if it was a leap year and the month is after February
    if (leapYear && monthNumber > 2)
        numberOfDays++;

    return numberOfDays;
}