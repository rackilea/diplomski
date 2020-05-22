import java.util.Random;
import java.util.Scanner;

public class NumberGuessclient {

    private static final String[] ANS = {
        "Your guess is too low\n", 
        "guessed in %d tries\n", 
        "Your guess is too high\n"
    };

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            NumberGuess game = new NumberGuess();
            System.out.println("Number generated from 0 to 100. Wanna take a guess(enter 0 to give up)");
            System.out.println("Let's take a guess: ");

            while (!game.isGameComplete()) {
                System.out.format(ANS[game.guess(scan.nextInt())+1], game.getNumberofGuesses());
            }

            System.out.println("Enter 1 for new game, 0 to quit: ");

            if (scan.nextInt() != 1) {
                System.out.println("Bye!");
                System.exit(0);
            }
        }
    }
}

class NumberGuess {
    private static final Random RAND_GENERATOR = new Random(System.nanoTime());
    int intGuess = RAND_GENERATOR.nextInt(101);
    int numGuess = 0;
    boolean isGuessCorrect = false;

    public int guess(int guessIn) {
        numGuess++;
        if (guessIn > intGuess) {
            return 1;
        } else if (guessIn == intGuess) {
            isGuessCorrect = true;
            return 0;
        } else {
            return -1;
        }
    }

    public int getNumberofGuesses() {
        return numGuess;
    }

    public boolean isGameComplete() {
        return isGuessCorrect;
    }
}