import java.util.*;
import java.util.Scanner;

public class assignment216{
  public static void main (String args[]){
    ArrayList<String> names = new ArrayList<String>();
    Scanner e = new Scanner(System.in);
    System.out.println("Enter command, or type 'quit' to exit \n");
    while (!e.nextLine().equalsIgnoreCase("quit")) {  // As long as input not equal to quit
      if (e.nextLine().equalsIgnoreCase("add") {
        System.out.println("Enter name to add:\n");
        String name = e.nextLine();
        names.add(name);
      }
      if (e.nextLine().equalsIgnoreCase("remove") {
        System.out.println("Enter name to remove:\n");
        String name = e.nextLine();
        names.remove(name);
      }
    }
    if(e.nextLine().equalsIgnoreCase("quit"){
      scanner.close();
      System.exit();
    }
  }
}