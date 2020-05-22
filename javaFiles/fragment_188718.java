import java.io.FileWriter;
import java.io.PrintWriter;

public class Main {
  public static void main(String[] args) throws Exception {
    String filename = "fileName.txt";
    String[] linesToWrite = new String[] { "a", "b" };
    boolean appendToFile = true;

    PrintWriter pw = null;
    if (appendToFile) {
      // if you append data to file then pass 'true' to FileWriter else pass false
      // PrintWriter needs an object of Writer type so we pass an anonymous object of
      // FileWriter to PrintWriter constructor
      pw = new PrintWriter(new FileWriter(filename, true));
    } else {
      pw = new PrintWriter(new FileWriter(filename));
      // pw = new PrintWriter(new FileWriter(filename, false));
    }
    for (int i = 0; i < linesToWrite.length; i++) {
      pw.println(linesToWrite[i]);
    }
    pw.flush();
    pw.close();
  }
}