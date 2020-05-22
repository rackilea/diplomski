@Test
public void testCeil() {
    final Calendar date = new GregorianCalendar();
    date.clear();
    date.set(2002, 3, 28, 13, 45, 01);

    System.out.println(date.getTime());
    System.out.println(DateUtils.ceiling(date, Calendar.HOUR).getTime());
    System.out.println(DateUtils.ceiling(date.getTime(), Calendar.HOUR));
    System.out.println(DateUtils.truncate(date, Calendar.HOUR).getTime());
    System.out.println(DateUtils.truncate(date.getTime(), Calendar.HOUR));
    System.out.println(date.getTime());
}