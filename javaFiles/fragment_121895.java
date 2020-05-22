public static int[] daysOfMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

public int daysOfYear(int day, int month, int year) {
    if (month == 0) {
        return day;
    }
    //specific case for leap year
    int leapOffset = 0;
    if (month == 2) {
        if (Year.of(year).isLeap()) {
            leapOffset = 1;
        }
    }
    return daysOfYear(day + daysOfMonth[month-1] + leapOffset, month - 1, year);
}