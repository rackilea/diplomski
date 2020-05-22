public static Date getFirstDayOfWeekDate() {
    Calendar cal = Calendar.getInstance();
    cal.set(Calendar.DAY_OF_WEEK,
            cal.getActualMinimum(Calendar.DAY_OF_WEEK));
    Date now = new Date();
    cal.setTime(now);
    int week = cal.get(Calendar.DAY_OF_WEEK);
    return new Date(now.getTime() - 24 * 60 * 60 * 1000 * (week - 1));
}