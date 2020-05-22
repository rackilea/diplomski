import java.util.Random;
import java.util.Scanner;

public class Guess {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random value = new Random();
        int computerGuess;
        int highValue = 100;
        int lowValue = 1;
        String myAnswer;
        do {
            computerGuess = value.nextInt(highValue - lowValue)+lowValue;
            System.out.println("I'm guessing that your number is " + computerGuess);
            myAnswer = in.nextLine();
            if (myAnswer.equals("tl")){
                lowValue = computerGuess + 1;
            } else if (myAnswer.equals ("th")){
                highValue = computerGuess - 1;
            }
        } while (!myAnswer.equals("y"));
        in.close();
        System.out.println("Thank you, Good Game.");
    }
}