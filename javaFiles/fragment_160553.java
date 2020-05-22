public static long days(Date startDate, Date endDate) {
    Calendar start = Calendar.getInstance();
    start.setTime(startDate);
    Calendar end = Calendar.getInstance();
    long daysBetween = 0;
    while(start.before(end)) {
        start.add(Calendar.DAY_OF_MONTH, 1);
        daysBetween++;
    }
    return daysBetween;
}