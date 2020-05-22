public class XMLDataHelperTest {

  public static void main(String[] args) {
    File file = new File(System.getProperty("user.dir"), "test.xml");
    if (file.isFile()) {
      assertTrue(file.delete());
    }

    // write it once
    XMLDataHelper helper = new XMLDataHelper(file.getAbsolutePath());

    // read it once
    helper = new XMLDataHelper(file.getAbsolutePath());
    System.out.println(file);
  }
}