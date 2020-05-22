public class CsvWriterTest {

private ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
private PrintStream printStream = new PrintStream(byteArrayOutputStream);

@Test
public void testWriter() {
    CsvWriter writer = new CsvWriter(printStream);
    ... old logic here ...
    writer.write(lines);

    String result = new String(byteArrayOutputStream.toByteArray());
    Assert.assertTrue(result.contains("two,fields"));