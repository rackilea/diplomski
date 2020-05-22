import static java.lang.System.*;

import java.util.Scanner;

public class DiscountRunner
{
public static void main( String [] args )
{
    Scanner keyboard = new Scanner(System.in);
    Discount bill=new Discount();
    out.print("Enter the original bill amount :: ");
    bill.amt = keyboard.nextInt();

    int discount;


    discount=bill.getDiscountedBill();

    System.out.println(discount);
    //instantiate a new Discount object called "bill"
    //print the output of bill.getDiscountedBill() with amt as the parameter

}

}

import static java.lang.System.*;

import java.util.Scanner;

public class Discount
{
//instance variables and constructors could be used, but are not really needed

int amt;
int bill;

//getDiscountedBill() will return final amount of the bill
//          if the bill is >2000, the bill receives a 15% discount



   public int getDiscountedBill()
   {
       if ( amt>2000)
           **bill=(int)(amt*.85);**
       if ( amt<=2000)
           bill=amt*1;

       return bill;
   }
}