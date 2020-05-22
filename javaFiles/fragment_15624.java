import java.util.Random;
import java.util.Scanner;

public class GuessLogic {

    Scanner input = new Scanner(System.in);
    boolean win;

    public boolean guess() {
        System.out.println("Guess a number between 1 and 100");
        int guess = input.nextInt();
        int answer = new Random().nextInt(100);
        win = false;
        if (guess > 100) {
            System.out.println("Your guess is out of the range");
        } else if (guess < 1) {
            System.out.println("Your guess is out of the range");
        } else if (guess == answer) {
            win = true;
        } else if (guess < answer) {
            System.out.println("Your guess is too low");
        } else if (guess > answer) {
            System.out.println("Your guess is too high");
        }
        return win;
    }

}