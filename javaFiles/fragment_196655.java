// This takes a 1-based month, e.g. January=1. If you want to use a 0-based
// month, remove the "- 1" later on.
public int countWeekendDays(int year, int month) {
    Calendar calendar = Calendar.getInstance();
    // Note that month is 0-based in calendar, bizarrely.
    calendar.set(year, month - 1, 1);
    int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

    int count = 0;
    for (int day = 1; day <= daysInMonth; day++) {
        calendar.set(year, month - 1, day);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == Calendar.SUNDAY || dayOfweek == Calendar.SATURDAY) {
            count++;
            // Or do whatever you need to with the result.
        }
    }
    return count;
}