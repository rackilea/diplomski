import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileReadingWithScanner {

  public static void main(String[] args) throws IOException {
    File file = new File("D:\\book.txt");
    String book = "";
    Scanner sc = new Scanner(file);
    /* Using this delimiter you will be able to read whole file in single line. */
    sc.useDelimiter("\\Z");
    book = sc.next();
    String[] episodeArr = book.split("$");
    //Do whatever you want.
  }
}