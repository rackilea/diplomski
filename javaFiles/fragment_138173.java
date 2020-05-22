public static void main(String[] args) {

    int year = 2004;
    checkLeapYear(year);

    int year1 = 2013;
    checkLeapYear(year1);
}

private static void checkLeapYear(int year) {
    if (year % 4 == 0) {
        System.out.println(year + " is a leap year");
    } else {
        System.out.println(year + " is not a leap year");
    }
}