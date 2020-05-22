public class Main {
  public static void main(String[] args) {
    String property = "java.io.tmpdir";

    String tempDir = System.getProperty(property);
    System.out.println("OS current temporary directory is " + tempDir);
  }
}