public static Date addDays(Date d, int days) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(d);
    cal.add(Calendar.DATE, days);
    return cal.getTime();
}