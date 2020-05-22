import java.util.Random;
import java.util.Scanner;

public class GuessMe {

    public static void main(String[] args) {

        int max = 15;

        int guess = 0;
        Random generator = new Random();
        int answer = generator.nextInt(max) + 1;
        Scanner scan = new Scanner(System.in);

        System.out.println("I'm thinking of a number between 1 and " + max + ". Guess what is it\n");
        do {

            System.out.print("Please choose a number between 1 and " + max + ":");
            guess = scan.nextInt();

            if (guess < 1 || guess > 15) {
                System.out.println("You did't enter a valid number, please try again");
            } else if (guess < answer) {
                System.out.println("Good guess, but mine is higher");
            } else if (guess > answer) {
                System.out.println("Good guess, but mine is low");
            }

        } while (guess != answer);

        System.out.println("Good guess, that's right!");

    }

}