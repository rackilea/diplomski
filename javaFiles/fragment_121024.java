import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Hangman {

    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);

        String[] CollectionOfWords = {"", "gravity", "banana", "gate", "processor", "momentum", "earth", "star", "light", "television", "pan", "cupboard"};

        int radmNumber = (int) Math.ceil(Math.random() * CollectionOfWords.length);
        int counter = 10;
        String radmWord = "banana"; //CollectionOfWords[radmNumber];

        char[] genRadmLetter = radmWord.toCharArray();
        char[] genRadmLetter2 = radmWord.toCharArray();
        for (int x = 0; x < genRadmLetter.length; x++) {
            genRadmLetter[x] = '?';
        }

        Set<Character> guesses = new HashSet<Character>();
        do {

            System.out.println("Guess a letter.");

            System.out.println(String.valueOf(genRadmLetter));
            System.out.println("Hello. Guess a letter.");
            char guessedLetter = Input.next().charAt(0);

            if (guesses.contains(guessedLetter)) {

                System.out.println("You've used this guess, guess again");

            } else {

                guesses.add(guessedLetter);
                boolean found = false;
                for (int rw = 0; rw < genRadmLetter2.length; rw++) {

                    if (genRadmLetter2[rw] == guessedLetter) {

                        genRadmLetter[rw] = guessedLetter;
                        found = true;

                    }

                }

                if (!found) {
                    System.out.println("Wrong letter, try again.");
                    counter = counter - 1;
                    System.out.println("Lives left: " + counter);
                }

            }

            boolean result = Arrays.equals(genRadmLetter, genRadmLetter2);
            if (result == true) {
                break;
            }

            if (counter == 0) {
                break;
            }

        } while (counter != 0);

        if (counter == 0) {
            System.out.println("You lose. The word was: " + radmWord);
        } else {
            System.out.println("Well done, you have guessed the word.");
            System.out.println("Your final score is: " + counter);
        }

    }

}