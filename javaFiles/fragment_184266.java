public class StreamsTest {

    InputStream inputStream;

    OutputStream outputStream;

    @Test
    public void sort_givenShuffledXml_returnsSortedXml() {
        // arrange
        YourClassUnderTest cut = new YourClassUnderTest();
        Comparator<?> comparator = new YourRealComparatorImpl();
        inputStream = new ByteArrayInputStream("unsortedXML".getBytes());
        outputStream = new ByteArrayOutputStream();

        // act
        cut.sort(inputStream, outputStream, comparator);

        //assert
        Assert.assertThat(outputStream.toString(),CoreMatchers.equalTo("sortedXml"));
   }
}