@Test
public void testOneMonthPeriodDays() {
    Period p = Period.between(LocalDate.of(2017, 06, 01), LocalDate.of(2017, 07, 01));
    assertEquals(0, p.getDays());
    assertEquals(1, p.getMonths());
}