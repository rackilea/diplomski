import java.util.*;
import java.math.*;
import java.text.*;


public class CorrectChange {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        BigDecimal AmtDue;      
        BigDecimal AmtPaid;


        NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);

        //User enters the amount that the customer owes
        System.out.println("Enter the amount below that is due to be paid.");
        System.out.print("$");
            AmtDue = input.nextBigDecimal();

            //Converts user's input into the currency format
            AmtDue = AmtDue.setScale(2, BigDecimal.ROUND_HALF_UP);
                double dAmtDue = AmtDue.doubleValue();
                    String eAmtDue = n.format(dAmtDue);

        //User enters the amount that the customer paid     
        System.out.println("Enter the amount below that has been paid.");
        System.out.print("$");
            AmtPaid = input.nextBigDecimal();

            //Converts user's input into the currency format
            AmtPaid = AmtPaid.setScale(2, BigDecimal.ROUND_HALF_UP);
                double dAmtPaid = AmtPaid.doubleValue();
                    String eAmtPaid = n.format(dAmtPaid);

            //Checks to see if the amount paid is more than the amount owed
            if (AmtDue.compareTo(AmtPaid)> 0){
                double dBal = AmtDue.subtract(AmtPaid).doubleValue();
                String eBal = n.format(dBal);
                System.out.println("You still owe: " + eBal.toString());
            }

            //Checks to see if the amount owed is more than the amount paid
            if (AmtDue.compareTo(AmtPaid)< 0){
                double dBal = AmtPaid.subtract(AmtDue).doubleValue();
                String eBal = n.format(dBal);


                    int DolBills = (int) (dBal / 1);
                    dBal = dBal % 1.0;

                    int quarters = (int) (dBal / .25);
                    dBal = dBal % .25;

                    int dimes = (int) (dBal / .10);
                    dBal = dBal % .10;

                    int nickles = (int) (dBal / .05);
                    dBal = dBal % .05;

                    int numPennies = (int) (dBal / .01);
                    //dBal = dBal % 0.01;

                System.out.println("You owe a balance of " + eAmtDue.toString() + ". Since you paid the amount of " + eAmtPaid.toString() + " your change is " + eBal.toString());
                System.out.println("Your change amount is as follows:\n" +
                    "\t" + DolBills + " $1 dollar bills \n" +
                    "\t" + quarters + " quarters \n" +
                    "\t" + dimes + " dimes \n" +
                    "\t" + nickles + " nickels \n" +
                    "\t" + numPennies + " pennies");

            }

            //Checks to see if the amount paid is equal to the amount owed
            if (AmtDue.compareTo(AmtPaid)== 0){
                    System.out.println("Your balance has been paid. Thank you for your business.");
            }

    }
    }