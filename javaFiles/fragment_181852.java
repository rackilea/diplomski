import java.text.DecimalFormat;
import java.util.Scanner;

public class NumberFormater {
   static DecimalFormat twoDpFormat = new DecimalFormat("#0.00");

   static String twoDecimalPlace(double usrInput) {
      String output = twoDpFormat.format(usrInput);
      return output;
   }

   public static void main(String[] args) {

      System.out.print("Enter a number on a line: ");
      Scanner input = new Scanner(System.in);
      double d = input.nextDouble();

      System.out.println("Output: " + twoDecimalPlace(d));
   }
}