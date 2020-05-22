@Test
void status_written_in_csv_format() {
    // Setup
    WriteCsvToResponse objectUnderTest = new WriteCsvToResponse ();
    StringWriter stringWriter = new StringWriter();
    PrintWriter printWriter = new PrintWriter(stringWriter);

    // Given
    Status status = ...

    // When
    objectUnderTest.writeStatus(printWriter, status);

    // Then
    String actualCsv = stringWriter.toString();
    assertThat(actualCsv.split("\n"))
       .as("Produced CSV")
       .containsExactly(
         "id,storeId,status",
         "42,142,OK");
}