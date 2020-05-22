import java.util.Random;
import java.util.Scanner;

class RockPaperScissors {

    public static final int ROCK = 1;
    public static final int PAPER = 2;
    public static final int SCISSORS = 3;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Let's play Rock, Paper, Scissors! (best out of 5)");

        for (int round = 0; round < 5; round++) {
            System.out.println("Enter either 1 for Rock, 2 for Paper or 3 for Scissors.");

            int numberGuessed = input.nextInt();

            Random generator = new Random();
            int computerNumber = generator.nextInt(3) + 1;

            if (numberGuessed == computerNumber) {
                System.out.println("It's a tie!");
            } else if (numberGuessed == 1 && computerNumber == 2) {
                System.out.println("You lose! I chose paper and paper smothers rock!");
            } else if (numberGuessed == 1 && computerNumber == 3) {
                System.out.println("You win! I chose scissors and rock smashes scissors!");
            } else if (numberGuessed == 2 && computerNumber == 1) {
                System.out.println("You win! I chose rock and paper smothers rock!");
            } else if (numberGuessed == 2 && computerNumber == 3) {
                System.out.println("You lose! I chose scissors and scissors cut paper!");
            } else if (numberGuessed == 3 && computerNumber == 2) {
                System.out.println("You win! I chose paper and scissors cut paper!");
            } else if (numberGuessed == 3 && computerNumber == 1) {
                System.out.println("You lose! I chose rock and rock smashes scissors!");
            } else if (numberGuessed != 1 || numberGuessed != 2 || numberGuessed != 3) {
                System.out.println("Invalid user input.");
            }
            System.out.println();
        }
    }
}