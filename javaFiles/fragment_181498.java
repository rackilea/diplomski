import java.util.Scanner;
public class practice {


public static void main(String[] args) {
 Scanner in = new Scanner(System.in);
 System.out.printf("Enter a string: ");
 String aString = in.next();
 int length = aString.length();


  if (length == 7) {
   char first =   aString.charAt(0);
   char second =  aString.charAt(1);
   char third =   aString.charAt(2);
   char fourth =  aString.charAt(3);
   char fifth =   aString.charAt(4);
   char sixth =   aString.charAt(5);
   char seventh = aString.charAt(6);
 System.out.println(String.format("Line 1: %s %s %s %s ", first, third, fifth, sixth));
 System.out.println(String.format("Line 2: %s %s %s ", second, fourth, sixth));
 System.out.println(String.format("Line 3: %s %s %s %s ", seventh, fifth, third, first));
}
else {
if (length < 7) {
 System.out.println("the length is less than 7");
}
  }
}

}