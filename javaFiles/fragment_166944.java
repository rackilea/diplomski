import java.util.*;
import java.io.*;

public class Primary {
   public static void main(String[] args) throws Exception {
      String clearText = ("");

      // Collect user input
      System.out.print("Type Text");
      clearText = scnr.next();

      // Create hash and display
      String hashText = HashService.generateHash(clearText);
      System.out.println(hashText);
   }
}

public class HashService {
  public static String generateHash(String fromText){
    // implementation here
    return null;
  }
}