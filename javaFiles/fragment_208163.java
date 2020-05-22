@Test
public void differenceDateTest() throws ParseException {
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
    Date date = dateFormat.parse("2016-02-29 12:21");
    Date date2 = dateFormat.parse("2016-03-01 12:21");
    System.out.println(date2.getTime() - date.getTime());
    long mili = date2.getTime() - date.getTime();
    System.out.println(TimeUnit.MILLISECONDS.toHours(mili)); // 24 hours.
}