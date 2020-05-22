import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {

        // create scanner object
        Scanner keyboard = new Scanner(System.in);

        // give user the game rules
        System.out.println("The computer has chosen a unique 4 digit number (No digits in the number repeat)\n"
                        + "Each time you guess incorectly you will get a hint. You must guess the number correctly in 5 tries or fewer to win.\n");

        int[] solution = numberGenerator();
        // ask user for their guess
        System.out.println("Please enter your guess: ");

        // read the user input and store it in a string
        String input = keyboard.nextLine();

        int[] guess1 = new int[4];

        for (int i = 0; i < 4; i++) {
            guess1[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
        }

        // this is some rough comparison code - you'll need to work on this

        if(solution[0] == guess1[0])
        {
            System.out.println("The first digit was correct!");
        }
        if(solution[1] == guess1[1])
        {
            System.out.println("The second digit was correct!");
        }
        if(solution[2] == guess1[2])
        {
            System.out.println("The third digit was correct!");
        }
        if(solution[3] == guess1[3])
        {
            System.out.println("The fourth digit was correct!");
        }

        System.out.println(Arrays.toString(guess1));

    }

    public static int[] numberGenerator() {

        // random number generator
        Random randy = new Random();

        // integer array with 4 positions (for each digit)
        int[] randArray = new int[4];

        // assigns a random value to temporary variable
        int a = randy.nextInt(9);
        int b = randy.nextInt(9);
        int c = randy.nextInt(9);
        int d = randy.nextInt(9);

        // tests to make sure there are no repeating digits in the number

        while (b == a) {
            b = randy.nextInt(9);
        }

        while (c == a || c == b) {
            c = randy.nextInt(9);
        }

        while (d == a || d == b || d == c) {
            d = randy.nextInt(9);
        }

        // assigns random integers to their location in the array
        randArray[0] = a;
        randArray[1] = b;
        randArray[2] = c;
        randArray[3] = d;

        // prints and returns the array with its values
        System.out.println(Arrays.toString(randArray));
        return randArray;
    }
}