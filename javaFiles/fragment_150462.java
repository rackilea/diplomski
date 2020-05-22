import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
public class Test2 {
 public static void main(String[] args) {

  Scanner scanner = new Scanner(System.in);
  System.out.println("Start the sequence by inputting a string DIFFERENT than 'quit'. When you DO want to end it, input 'quit'");
  String longest = "";

  List<String> ascending = new ArrayList<String>();
  List<String> descending = new ArrayList<String>();
  int loop = 0;
  Comparator<String> comparator = new Comparator<String>() {
   public int compare(String o1, String o2) {
    return o1.length() - o2.length();
   }
  }


  String encore = "";
  while(true){
   loop++;
   System.out.println("Enter the string you want to put in your sequence of strings");
   encore = scanner.nextLine();
   if (encore.equalsIgnoreCase("quit")) {
    break;
   }

   encore = encore.replaceAll("\\s+", ""); // this way, the length of the strings is only defined by the characters in the string, and not characters + whitespaces

   ascending.add(encore);
   descending.add(encore);
   Collections.sort(ascending, comparator);
   Collections.sort(descending, comparator);
   Collections.reverse(descending);
  }

  for (String str: ascending) {
   if (str.length() > longest.length()) {
    longest = str;
   }
  }

  if (ascending.size() > 0) {
   System.out.println("Here are your strings in ascending order : " + ascending);
   System.out.println("Here are your strings in descending order : " + descending);
   System.out.println("Here is the longest string : " + longest);
  } else {
   System.out.println("You have not entered any strings, therefore the program doesn't display any string :("); // customised message.
  }

  scanner.close();
 }
}