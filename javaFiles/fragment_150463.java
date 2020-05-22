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

  List < String > list = new ArrayList < > ();
  int loop = 0;

  String encore = "";
  while(true){
   loop++;
   System.out.println("Enter the string you want to put in your sequence of strings");
   encore = scanner.nextLine();
   encore = encore.replaceAll("\\s+", ""); // this way, the length of the strings is only defined by the characters in the string, and not characters + whitespaces

   if (encore.equalsIgnoreCase("quit")) {
    break;
   }
   list.add(encore);
  }

  for (String str: list) {
   if (str.length() > longest.length()) {
    longest = str;
   }
  }

  if (list.size() > 0) {
   Collections.sort(list, new Comparator<String>() {
    @Override
    public int compare(String o1, String o2) {
     return o1.length() - o2.length();
    }
   });
   System.out.println("Here are your strings in ascending order : " + list);
   Collections.reverse(list);
   System.out.println("Here are your strings in descending order : " + list);
   System.out.println("Here is the longest string : " + longest);
  } else {
   System.out.println("You have not entered any strings, therefore the program doesn't display any string :("); // customised message.
  }

  scanner.close();
 }
}