import java.util.*;
import java.io.*;

public class Primary {
   public static void main(String[] args) throws Exception {
      String clearText = ("");

      // Collect user input
      System.out.print("Type Text");
      clearText = scnr.next();

      // Create hash and display
      HashedPassword hash = new HashedPassword(clearText);
      String hashText = hash.getHashedPW();
      System.out.println(hashText);
   }
}

public class HashedPassword {
  private String hashedPW = ""
  public HashedPassword(String fromText){
    // Assign hashedPW with some logic
    hashedPW = fromText;
  }

  public getHashedPW(){
    return hashedPW;
  }
}