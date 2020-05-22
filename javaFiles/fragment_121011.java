public static Date getFirstOfLastMonth() {
     return getFirstOfPreviousMonth(new Date());
}

public static Date getFirstOfPreviousMonth(Date now) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(now);
    cal.add(Calendar.MONTH, -1);
    cal.set(Calendar.DAY_OF_MONTH, 1);

    return cal.getTime();
}