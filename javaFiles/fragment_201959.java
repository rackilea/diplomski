import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws FileNotFoundException {
    File inputFile = new File("input.txt");
    Scanner in = new Scanner(inputFile);
    PrintWriter out = new PrintWriter("output.txt");

    //in.useDelimiter("[^A-Za-z]+");
    String input = "";
    int count = 0;
    while (in.hasNextLine()) { 
      input = in.nextLine();
      input = input.replace(".", "");
      input = input.replace("!", "");

      Scanner lineScanner = new Scanner(input);
      String words = "";
      while (lineScanner.hasNext()) {
        count++;
        words = lineScanner.next();
        out.printf("%10.10s", words);
        if (count % 2 == 0) {
          out.println();
        }
      }
    }
      out.close();
  }
}