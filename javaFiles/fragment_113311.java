public static int lengthOfMonth(int year, int month) {
    GregorianCalendar c = new GregorianCalendar(year, month - 1, 1);
    c.add(Calendar.MONTH, 1);
    c.add(Calendar.DAY_OF_MONTH, -1);
    return c.get(Calendar.DAY_OF_MONTH);
}