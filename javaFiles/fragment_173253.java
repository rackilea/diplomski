import java.util.Scanner;

public class SoftwareSales
{
   public static void main(String[] args)
   {

      Scanner keyboard = new Scanner(System.in);

      int sales = 99;

      int quantity;
      double total;
      double rate = 0; // set rate to what you need.
      double discount;

      System.out.print ("Enter amount of packages purchased: ");
            quantity = keyboard.nextInt();

      total = quantity * sales;
      discount = total * rate;
      total = total - discount;

      if(!(total < 10))
         System.out.println("No discount." + "Your total is: " + total);
      else if(total >= 19)
         rate = .20f;
      else if(total >= 49)
         rate = .30f;
      else if(total >= 99)
         rate = .40f;
      else
         rate = .50f;

      System.out.println("Your discount is " + discount + 
                         ". Your total is: " + total);
   }
}