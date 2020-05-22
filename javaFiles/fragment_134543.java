private static Date addWeekdaysToDate(Date date, int weekdays) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    int originalDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
    int numWeeks = weekdays / 5;
    int remainderDays = weekdays % 5;
    cal.add(Calendar.DAY_OF_MONTH, numWeeks * 7 + remainderDays);

    int adjustmentDays = 0;
    if (originalDayOfWeek == Calendar.SUNDAY) {
        adjustmentDays = 1;
    } else if (originalDayOfWeek + remainderDays > Calendar.FRIDAY) {
        adjustmentDays = 2;
    }
    cal.add(Calendar.DAY_OF_MONTH, adjustmentDays);
    return cal.getTime();
}