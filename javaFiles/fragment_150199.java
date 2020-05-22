public static Calendar fromSecondsSince2000( long seconds ) {
    final long epoch = 946684800000L;
    Calendar cal = GregorianCalendar.getInstance();
    long timestamp = epoch + seconds * 1000L;
    cal.setTime(new Date(timestamp));
    return cal;
}