public class TeeOutputStreamTest {

   @Test
   public void testPrintToMultipleStreams() throws Exception {
      final String fileName1 = "/tmp/fileOne.txt";
      final String fileName2 = "/tmp/fileTwo.txt";
      final String fileName3 = "/tmp/fileThree.txt";

      final TeeOutputStream tos = new TeeOutputStream(new FileOutputStream(
              fileName1), new TeeOutputStream(new FileOutputStream(fileName2),
              new FileOutputStream(fileName3)));
      final PrintWriter writer = new PrintWriter(tos);

      writer.println("Hello World");
      writer.close();
   }
}