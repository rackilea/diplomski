@Test
public void previousYear() {
    Calendar input = Calendar.getInstance();
    input.clear();
    input.set(2009, Calendar.JANUARY, 5);

    Date result = getFirstOfLastMonth(input.getTime());

    Calendar output = Calendar.getInstance();
    output.setTime(result);
    assertThat(output.get(Calendar.YEAR), is(2008));
    assertThat(output.get(Calendar.MONTH), is(Calendar.DECEMBER));
    assertThat(output.get(Calendar.DAY_OF_MONTH), is(1));
}