@Test
public void testDay() {
    Assert.assertEquals(LocalDate.of(2015, Month.FEBRUARY, 25).getDayOfYear(), daysOfYear(25, 1, 2015));
    Assert.assertEquals(LocalDate.of(2014, Month.MARCH, 25).getDayOfYear(), daysOfYear(25, 2, 2014));
    Assert.assertEquals(LocalDate.of(2013, Month.MAY, 25).getDayOfYear(), daysOfYear(25, 4, 2013));
    Assert.assertEquals(LocalDate.of(2012, Month.JUNE, 25).getDayOfYear(), daysOfYear(25, 5, 2012));
}