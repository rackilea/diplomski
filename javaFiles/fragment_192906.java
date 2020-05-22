import java.io.*;
import java.util.Scanner;
import java.io.File;

public class temp
{
  public static void main (String[] args) {
      Scanner scan = new Scanner(System.in);
      int cases = scan.nextInt();
      String first = "", second = "";

      for (int i =0; i < cases; i++) {
          first = scan.next();
          second = scan.next();
          check(first, second);
      }

      scan.close();
  }
  public static void check(String first, String second)
  {
      if (first.length() > second.length())
          System.out.println(first);
      else
          System.out.println(second);
  }
}