import java.text.DecimalFormat; // Needed for 2 decimal place amounts
import java.util.Scanner; // Needed for the Scanner class

public class Program2 {
    public static void main(String[] args) {
        BankAccount account; // To reference a BankAccount object
        double balance, // The account's starting balance
            interestRate, // The annual interest rate
            pay, // The user's pay
            cashNeeded; // The amount of cash to withdraw

        // Create a Scanner object for keyboard input.
        Scanner keyboard = new Scanner(System.in);

        // Create an object for dollars and cents
        DecimalFormat formatter = new DecimalFormat("#0.00");

        // Get the starting balance.
        System.out.print("What is your account's " + "starting balance? ");
        balance = keyboard.nextDouble();

        // Get the monthly interest rate.
        System.out.print("What is your monthly interest rate? ");
        interestRate = keyboard.nextDouble();

        // Create a BankAccount object.
        account = new BankAccount(balance, interestRate);

        // Get the amount of pay for the month.
        System.out.print("How much were you paid this month? ");
        pay = keyboard.nextDouble();

        // Deposit the user's pay into the account.
        System.out.println("We will deposit your pay into your account.");
        account.deposit(pay);
        System.out.println("Your current balance is " + formatter.format( account.getBalance()  ));

        // Withdraw some cash from the account.
        System.out.print("How much would you like to withdraw? ");
        cashNeeded = keyboard.nextDouble();
        account.withdraw(cashNeeded);

        // Add the monthly interest to the account.
        account.addInterest();

        // Display the interest earned and the balance.
        System.out.println("This month you have earned " + formatter.format( account.getInterest() ) +
            " in interest.");
        System.out.println("Now your balance is " + formatter.format( account.getBalance() ) );
    }
}