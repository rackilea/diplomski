import java.util.Random;
import java.util.Scanner;
class TooHighException extends Exception {
}
class TooLowException extends Exception {
}
class CorrectException extends Exception {
}
public class HighLow {
     /**
     * @param args the command line arguments
     * @throws TooLowException
     * @throws TooHighException
     * @throws CorrectException
     */
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int number = random.nextInt(100);
        int guess = -1;
        while (guess != number) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            try {
                if (guess < number) {
                    throw new TooLowException();
                } else if (guess > number) {
                    throw new TooHighException();
                } else {
                    throw new CorrectException();
                }
            } catch(Exception e) {
            System.out.println(e);
            }
        }
    } // end main
} // end class