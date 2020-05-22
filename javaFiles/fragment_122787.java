@Test
public void shouldParseDateCorrectly() throws Exception {
    // Given
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    format.setTimeZone(TimeZone.getTimeZone("UTC"));

    // When
    Date parsedDate = format.parse("21/08/2012");

    // Then
    Assert.assertThat(parsedDate.toString(), is("Tue Aug 21 02:00:00 CEST 2012"));
    Assert.assertThat(parsedDate.toGMTString(), is("21 Aug 2012 00:00:00 GMT"));
}