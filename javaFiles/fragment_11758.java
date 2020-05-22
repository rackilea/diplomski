import java.util.Scanner;
public class Junk {
public static void main(String[] args) {
Scanner Keyboard = new Scanner(System.in);
System.out.print("Enter a String: ");
String str = Keyboard.nextLine();
for (int i = 0; i < str.length(); i++){
if (str.substring(i, i+1).equalsIgnoreCase("a")){
count++;
}
}
System.out.println("Number of A: "+count);