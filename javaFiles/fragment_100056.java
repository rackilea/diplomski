import java.util.Scanner;
public class Luhn {
private static Scanner input;

public static void main(String... args) {
input = new Scanner(System.in);
System.out.print("Enter number to validate:\n");
String pnr = input.nextLine();
boolean result = luhn(pnr);
printMessage(result);
input.close();
}

static boolean luhn(String pnr){
// this only works if you are certain all input will be at least 10   characters
int extraChars = pnr.length() - 10;
if (extraChars < 0) {
  throw new IllegalArgumentException("Number length must be at least 10 characters!");
}
pnr = pnr.substring(extraChars, 10 + extraChars);
int sum = 0;
for (int i = 0; i < pnr.length(); i++){
  char tmp = pnr.charAt(i);
  int num = tmp - '0';
   int product;
   if (i % 2 != 0){
     product = num * 1;
   }
   else{
    product = num * 2;
  }
   if (product > 9)
    product -= 9;
   sum+= product;              
 }
  return (sum % 10 == 0);
 }

 private static void printMessage(boolean valid) {
  if (valid){
  System.out.print("Valid!\r");
  }
  else{
  System.out.print("Invalid!");
 }
 }
}