int WEEKDAY_OF_FIRST_DAY_IN_FIRST_YEAR = 3; // 0 for monday, 1 for tuesday, etc.
int LENGTH_OF_WEEK = 7;
int DAYS_IN_YEAR = 365; // 31 + 32 + 31 + 32 + 31 + 30 + 30 + 30 + 29 + 29 + 30 + 30
int DAYS_OF_MONTHS[] = { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30 };

public static int day(int M, int D, int Y) {
    int firstDayInCurrentYear = WEEKDAY_OF_FIRST_DAY_IN_FIRST_YEAR + 
        (Y * DAYS_IN_YEAR) % LENGTH_OF_WEEK;
    int firstDayOfMonth = firstDayInCurrentYear;

    for (int month = 0; month < M; month++) {
        firstDayOfMonth = 
            (firstDayOfMonth + DAYS_OF_MONTH[month]) % LENGTH_OF_WEEK;
    }

    return firstDayOfMonth;
}