import java.util.Random;
import java.util.Scanner;

class Guess {

    public static void main(String[] args) {

        int maxGuesses = 3;

        System.out.println("I'm thinking of a letter in the range a to j. You have " + maxGuesses + " guesses. ");

        Random r = new Random();
        char i = (char) (r.nextInt(10) + 'a');

        Scanner sc = new Scanner(System.in);
        String[] guessDescription = { "First", "Second", "Third" };

        for (int g = 0; g < maxGuesses; g++) {
            // use predefined guess description for 1-3, otherwise a generic description that works for any number of guesses above 3
            if (g < guessDescription.length) {
                System.out.print("Enter your " + guessDescription[g] + " guess:");
            } else {
                       System.out.print("Enter guess #" + (g + 1) + ":");
                   }

            char b = sc.next().charAt(0);

            if (b > i) {
                System.out.println("Your guess is too high. ");

            } else if (b < i) {
                       System.out.println("Your guess is too low. ");
                   } else if (b == i) {
                              System.out.println("You win! ");
                              return;
                          }
        }
        System.out.println("You lose. The letter was " + i + ".");
    }
}