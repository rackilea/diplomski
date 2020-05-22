public static int packTimeFields(int year, int month, int day, int hour, int minute) {
    checkRange("year", year, 2000, 2127);
    checkRange("month", month, 1, 12);
    checkRange("day", day, 1, 31);
    checkRange("hour", hour, 0, 23);
    checkRange("minute", minute, 0, 59);
    return day + (month-1) * 32 + (year-2000) * 512 + minute * 65536 + hour * 65536 * 64;
}

private static void checkRange(String name, int value, int min, int max) {
    if (value < min || value > max)
        throw new IllegalArgumentException(name+" "+value+" is not in valid range "+min+"..."+max);
}