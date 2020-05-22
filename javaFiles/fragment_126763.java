import java.util.*;
import java.io.*;
public class fread {
  public static void main (String[] args) {
    Scanner scan = new Scanner(System.in);

    String even = "2.txt";
    String odd = "1.txt";
    String line = "";

    int lineNumber = 0;

    while (scan.hasNext() )
    {
      line = scan.nextLine();
      if (lineNumber++ % 2 == 1)
        writeText(even, line);
      else
        writeText(odd, line);
    }
  }
  static void writeText(String filename, String ltw)
  {
    try
    {
      BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));
      bw.write(ltw);
      bw.newLine();
      bw.close();
    }
    catch ( IOException e)
    {
      e.printStackTrace();
    }
  }
}