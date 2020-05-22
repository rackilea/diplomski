@Test
public void testGetDateFromDateTime() {
    DateTimeZone timezone = DateTimeZone.forID("US/Eastern");
    Date date = new DateTime(2011, 11, 11, 17, 0, 0, 0, timezone).toDate();

    String formattedDate = unitUnderTest.getDateFromDateTime(date, true);

    Assert.assertEquals(formattedDate, "11/11/2011");
}