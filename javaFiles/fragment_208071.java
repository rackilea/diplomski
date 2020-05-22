import java.io.*;
import java.util.*;
public class ClassA {
  public void writer() throws IOException {
    PrintWriter writer = new PrintWriter("Name.txt", "UTF-8");
    Scanner in = new Scanner(System.in);
    writer.println("The first line");

    writer.close();
  }
}