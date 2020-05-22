import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class HangmanDriver {

public static final int mistakes_MAX = 6;

public static void main(String[] args) throws FileNotFoundException {
    File myFile = new File("PATH TO YOUR KEYBOARD FILE");
    String myText = "";
    Scanner in = new Scanner(myFile);
    while(in.hasNextLine()) {
        myText += (in.nextLine() + "\n");
    }
    in.close();

    String myWord = "";
    boolean stillPlaying = true;

    while(stillPlaying) {
        in = new Scanner(System.in);
        System.out.println("Enter the word for new game: ");
        myWord = in.nextLine().toUpperCase();
        playGame(in, false, 0, 0, myWord, myText);
        System.out.println("Would you like to play again? [Y/N]");
        char ans = in.next().charAt(0);
        if(ans != 'y' && ans != 'Y')
            stillPlaying = false;
    }

    System.out.println("Goodbye.");

}

public static void playGame(Scanner in, boolean isOver, int mistakes, int correct, String word, String text) {
    if(isOver == false) {   
        System.out.println("\n" + text + "\n\nEnter a Letter (Must Be Upper Case)");
        char letter = in.next().charAt(0);      
        if(text.indexOf(letter) != -1) {
            text = text.replace(letter, '-');
            if(word.indexOf(letter) != -1) {
                for(char c : word.toCharArray()) {
                    if(letter == c)
                        correct++;
                }
                System.out.println("Good guess!");
                if(correct == word.length()) {
                    System.out.println("You won!");
                    playGame(in, true, mistakes, correct, word, text);
                } else {
                    playGame(in, false, mistakes, correct, word, text);
                }
            } else {
                mistakes++;
                System.out.println(mistakes_MAX-mistakes + " guesses left.");
                if(mistakes == mistakes_MAX) {
                    System.out.println("Game Over!");
                    playGame(in, true, mistakes, correct, word, text);
                } else {
                    playGame(in, false, mistakes, correct, word, text);
                }
            }
        } else {
            System.out.println("That is not an option. Try Again.\n\n");
            playGame(in, false, mistakes, correct, word, text);
        }
    }
}

}