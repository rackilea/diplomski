public class RandomNumberGuesser {
public static void main(String[] args) {
    // UIManager m1=new UIManager();
    Color g = Color.gray;
    Color lg = g.brighter();
    UIManager.put("OptionPane.background", lg);
    UIManager.put("Panel.background", lg);

    Random random = new Random();
    int attempts = 0; // Number of attempts

    int randomNumber = random.nextInt(100);
    System.out.println(randomNumber);

    // This outside the loop so is showed just ONE time
    JOptionPane.showMessageDialog(null,
                    "This program will generate a random number from 0 to 100 which you have to guess.", "Number Guesser", JOptionPane.INFORMATION_MESSAGE);

    while (true) {

        attempts++;

        String guess = JOptionPane.showInputDialog(null, "Guess a number.",
                "Guess", JOptionPane.QUESTION_MESSAGE);
        if (guess == null) {
            System.out.println("The user has terminated the program");
            System.exit(0);
        }
        int guess1 = Integer.parseInt(guess);

            if (guess1 > 100 || guess1 < 0)
                JOptionPane
                        .showMessageDialog(
                                null,
                                "Guess is out of range!\nPlease enter valid input.",
                                "Invalid Input",
                                JOptionPane.WARNING_MESSAGE);

            else if (randomNumber > guess1)
                JOptionPane.showMessageDialog(null,
                        "You guessed too low.\nGuess again!", "Your guess",
                        JOptionPane.INFORMATION_MESSAGE);

            else if (randomNumber < guess1)
                JOptionPane.showMessageDialog(null,
                        "You guessed too high.\nGuess again!",
                        "Your guess", JOptionPane.INFORMATION_MESSAGE);

            else {
                JOptionPane
                        .showMessageDialog(null,
                                "You guessed the number right!\nIt took you "
                                        + attempts + " attempt(s) to guess it.",
                                "Congratulations!",
                                JOptionPane.INFORMATION_MESSAGE);
                if (JOptionPane.showConfirmDialog(null,
                        "Want to play again?", "Play again?",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
                    System.out.println("Play again soon!");
                    System.exit(0);
                } else {
                    randomNumber = random.nextInt(100);
                    System.out.println(randomNumber);
                    attempts = 0;
                }
            }
        }
    }
}