private static Date date(final int day, final int month) {
    final Calendar calendar = Calendar.getInstance();
    calendar.set(2012, month, day);
    final Date result = calendar.getTime();
    return result;
}