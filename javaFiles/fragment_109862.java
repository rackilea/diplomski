import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GuessChar {

    public static void main(String[] args) throws IOException {
        char expected = 'k';
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Guess the letter now.");
        while (true) {
            String line = stdin.readLine();
            if (line == null) {  // end of input
                System.out.println("Giving up, eh?");
                break;
            } else if (line.isEmpty()) {
                System.out.println("Sorry, that was no input at all.");
            } else if (line.charAt(0) == expected) {
                System.out.println("Well done!");
                break;
            } else {
                System.out.println("Sorry, please try again.");
            }
        }
    }
}