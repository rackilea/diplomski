import java.util.*;

class GuessingGame {
    private static final Random rng = new Random();
    private int number;

    public void generateNumber() {
        number = rng.nextInt(10);
    }

    public int guess(int guess) {
        return Integer.compare(guess, number);
    }

    public int getNumber() {
        return number;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GuessingGame game = new GuessingGame();
        game.generateNumber();
        System.out.println("Guess a number:");
        int n = sc.nextInt();
        int result = game.guess(n);
        if (result < 0)
            System.out.println("You guessed too low!");
        else if (result > 0)
            System.out.println("You guessed too high!");
        else
            System.out.println("You win!");
        System.out.println("You guessed: " + n);
        System.out.println("The actual number was: " + game.getNumber());
    }
}