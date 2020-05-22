public static boolean isFirstDayOfMonth(final Date date)
{
    final Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    final int dom = cal.get(Calendar.DAY_OF_MONTH);
    return dom == 1;
}