public static long normalizeDate(long startDate) {
    // normalize the start date to the beginning of the (UTC) day
    GregorianCalendar date = (GregorianCalendar)     GregorianCalendar.getInstance(TimeZone.getTimeZone("UTC"));
    date.setTime(new Date(startDate));
    date.set(Calendar.HOUR_OF_DAY, 0);
    date.set(Calendar.MINUTE, 0);
    date.set(Calendar.SECOND, 0);
    date.set(Calendar.MILLISECOND, 0)

    //transform your calendar to a long in the way you prefer
}