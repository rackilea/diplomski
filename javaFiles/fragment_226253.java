import java.util.Scanner;
import java.util.Random;
import java.util.*;

public class sda {
    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);
        Scanner lineInput = new Scanner(System.in);
        Random rand = new Random();

        String choices[] = { "rock", "paper", "scissors" };

        int winRounds = 0;
        boolean running = true;

        int rounds = 0;
        int wins = 0;
        int loses = 0;

        String yourChoice = "";
        String compChoice = "";
        while (running = true) { // main loop

            try {
                System.out
                        .println("Enter the amount of rounds you want to play: ");
                rounds = input.nextInt(); // gets input
                winRounds = (rounds / 2) + 1;
                System.out.println("You are playing best of " + winRounds
                        + " out of " + rounds);

                running = false; // breaks off from loop

                while (wins < winRounds && loses < winRounds) {
                    System.out
                            .println("Enter either Rock, Paper or Scissors: ");
                    yourChoice = lineInput.nextLine();
                    yourChoice= yourChoice.toLowerCase();
                    if (Arrays.asList(choices).contains(
                            yourChoice)) { // what use entered
                        break;
                    } else {
                        System.out
                                .println("You did not enter either Rock, Paper or Scissors.");
                        running = false; // exit program
                    }

                    compChoice = choices[rand.nextInt(choices.length)];
                    System.out.println(compChoice);

                }
            } catch (Exception e) { // if error pops up
                System.out.println("You DID NOT enter a WHOLE NUMBER.");
                break;
            }

        }

        input.close();
        lineInput.close();
    }
}