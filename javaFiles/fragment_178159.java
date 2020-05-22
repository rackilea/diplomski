public static boolean isEqualDate(String toCompare) throws Exception {
    DateFormat df = new SimpleDateFormat("dd-MMM-yy");
    Date toCompareDate = df.parse(toCompare);
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.HOUR, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);
    return toCompareDate.equals(calendar.getTime());
}