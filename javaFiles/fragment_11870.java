package foo;

import java.io.InputStream;
import java.util.Scanner;

public class TestResource {
   public static void main(String[] args) {
      ClassLoader classLoader = ClassLoader.getSystemClassLoader();     
      String resourceName = "foo/movies.txt"; // path relative to classloader
      InputStream inStream = classLoader.getResourceAsStream(resourceName);
      Scanner scanner = new Scanner(inStream);
      while (scanner.hasNextLine()) {
         System.out.println(scanner.nextLine());
      }
      if (scanner != null) {
         scanner.close();
      }
   }   
}