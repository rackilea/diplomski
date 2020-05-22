import java.io.File;

public class Main {
  public static void main(String[] args) {
    File myArchive = new File("MyDocument.txt");
    boolean x = true;
    try {
      x = myArchive.createNewFile();
    } catch (Exception e) {
      e.printStackTrace();
    }
     System.out.println(x);
  }
}