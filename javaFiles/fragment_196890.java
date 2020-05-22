import java.util.Scanner;

public class CoinChange {
    public static void main(String[] args) {
        float amt;
        int cents, quarter, dime, nickle, penny;

        Scanner keyboard = new Scanner(System.in);

        System.out.print("Change in Coins\n" + "----------------\n\n");

        System.out.println("Enter the amount less than $1.00, but\n"
                + "more than zero.");

        System.out.print("\nEnter amount: ");

        amt = keyboard.nextFloat();
        keyboard.close();

        cents = (int) (amt * 100);

        quarter = cents / 25;
        cents = cents % 25;

        dime = cents / 10;
        cents = cents % 10;

        nickle = cents / 5;
        cents %= 5;

        penny = cents;

        System.out.println("$" + amt + " = " + quarter + " quarters, " + dime
                + " dimes, " + nickle + " nickles and " + penny + " pennies");

    }
}