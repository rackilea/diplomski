import java.text.DecimalFormat;



public class Visitor {


    public static void main (String[] args) {
        compound (0.5, 1500, 1);
    }

    public static double compound (double interestRate, double currentBalance, int year) {

        for (; year <= 9 ; year ++) {

        System.out.println ("At year " + year +  ", your total amount of money is "+Double.parseDouble(new DecimalFormat("#.##").format(currentBalance)));


        currentBalance = currentBalance + (currentBalance * interestRate);  
        }
        System.out.println ("Your final balance after 10 years is " + currentBalance);
        return currentBalance;
    } 
}