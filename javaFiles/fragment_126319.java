public static final int lastDayOfWeek = Calendar.SATURDAY;

/** month is 1 through 12 for Jan through Dec */
public static List<Date> lastDayOfLastWeek(int year, int month) {
    Calendar cal = Calendar.getInstance();
    // set to a day in the month in question; Calendar’s month is 0-based, so subtract 1
    cal.set(year, month - 1, 1);
    // set to last day of month
    cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
    List<Date> result = new ArrayList<Date>(2);
    result.add(cal.getTime());
    // is this also the last day of the week?
    int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
    if (dayOfWeek != lastDayOfWeek) { // no
        // set to last day of week and add one more date to result
        cal.add(Calendar.DAY_OF_WEEK, lastDayOfWeek - dayOfWeek);
        result.add(cal.getTime());
    }
    return result;
}