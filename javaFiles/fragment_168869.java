import java.util.Scanner;

public class Carloan {
    public static void main(String[] args){

        double P;
        double Y;
        double R;

        Scanner input = new Scanner (System.in);

        //double P;
        System.out.println("Enter loan amount: $");

        P = input.nextDouble();

        //double Y;
        System.out.println("Enter number of years: ");

        Y = input.nextDouble();

        //double R;
        System.out.println("Enter interest rate: %");

        R = input.nextDouble();

        //calculate all these values after you have P, Y, and R defined, not before
        double r = R / 1200;
        double n = 12 * Y;        
        double payment  = (P * r) / (1 - Math.pow(1+r, -n));
        double interest = payment * n - P;

        System.out.println("Monthly payments = " + payment);
        System.out.println("Total interest   = " + interest);

    }
}