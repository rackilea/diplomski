import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class RockPaperScissors {
    private static final int ROCK = 1;
    private static final int PAPER = 2;
    private static final int SCISSORS = 3;

    private Random computerChooses = new Random();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RockPaperScissors().play();
            }
        });
    }

    protected void play() {
        String rounds;
        String userChooses;
        int round = 0;
        int userChoice;

        // CREATE THE INPUT FOR THE USER
        try {
            rounds = JOptionPane.showInputDialog(null, "How many rounds do you want to play?");
            round = Integer.parseInt(rounds);

            // CREATE COUNTER
            for (int x = 0; x < round; x++) {
                int computerChoice = computerChooses.nextInt(3) + 1;
                JOptionPane.showMessageDialog(null, "This is round " + x + ".");

                // START GAME
                userChooses = JOptionPane.showInputDialog(null, "Enter 1)rock, 2)paper, or 3)scissors!");
                userChoice = Integer.parseInt(userChooses);

                String message = null;
                switch (userChoice) {
                case ROCK:
                    switch (computerChoice) {
                    case ROCK:
                        message = "You tied computer. You both chose rock";
                        break;
                    case PAPER:
                        message = "You win.";
                        break;
                    case SCISSORS:
                        message = "You loose";
                        break;

                    }
                    break;
                case PAPER:
                    switch (computerChoice) {
                    case ROCK:
                        message = "You win.";
                        break;
                    case PAPER:
                        message = "You tied computer. You both chose paper";
                        break;
                    case SCISSORS:
                        message = "You loose";
                        break;

                    }
                    break;
                case SCISSORS:
                    switch (computerChoice) {
                    case ROCK:
                        message = "You loose";
                        break;
                    case PAPER:
                        message = "You win";
                        break;
                    case SCISSORS:
                        message = "You tied computer. You both chose scissors";
                        break;

                    }
                    break;

                }
                JOptionPane.showMessageDialog(null, message);
            }
        } catch (Exception ex) {
            JOptionPane.showInputDialog(null, "That wasn't a number!", "Error!", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, "You have not entered correct number! Terminating program!");
            System.exit(0);
        }
    }
}