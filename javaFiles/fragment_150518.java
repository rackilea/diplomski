import java.util.Scanner;

public class ReverseDoubleChar {
public static void main(String[] args) {

Scanner input = new Scanner(System.in);
System.out.println("Enter a string ");
String str = input.nextLine();
String new_str = "";

String result = "";
for (int i = str.length() - 1; i >= 0; i--) { //Iterate through string backwards
    result += str.substring(i, i + 1) + str.substring(i, i + 1); //Concatenation
    String result2 = null;
    result2 = result;
    // System.out.println(result2); //Don't print each double char since you're concatenating above
}
System.out.println(result); //Print full double-charred string after loop
}

}