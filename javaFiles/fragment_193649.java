import java.util.Scanner;
import java.util.InputMismatchException;

public class Guess {
    public static void main(String[] args) { // No need to throw IOException
        int input = -1, answer = 64; // Initialize input for if the user types
                                     // in invalid input on the first loop

        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("I'm thinking of a number between 1 and 100.");
            System.out.println("Can you guess it?");

            try {
                input = scan.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Invalid Input!");
                continue; // Skips to the next loop iteration if invalid input
            }

            if (input == answer) 
                System.out.println("**RIGHT**");
            else {
                System.out.println("...Sorry, you're too " + (input < answer ? "low" : "high"));
                // ^ Ternary operator; you may not have learned this yet, but it 
                // just does a conditional return (if the value before the '?' is
                // true, then return the value before the ':'; else return the 
                // value after.)
                System.out.println("Try again!");
            }
        } while (answer != input);
    }
}