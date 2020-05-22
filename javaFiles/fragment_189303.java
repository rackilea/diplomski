import java.util.Random;
import java.util.Scanner;

public class GuessingGame
{
    public static void main(String[] args)
    {

        Random rand = new Random();
        int TAL = rand.nextInt(20) + 1;
        int FORSØG = 0;
        Scanner input = new Scanner (System.in);
        int guess;
        int loft;
        boolean win = false;

        boolean keepPlaying = true;
        while ( keepPlaying )
        {
            Scanner tastatur = new Scanner(System.in);
            System.out.print("Enter a maximum limit: ");
            loft = tastatur.nextInt();
            TAL = (int) (Math.random() * loft + 1);

            // *** LOOK HERE ***

            // Reset the 'win' flag here, otherwise the player receives an
            // automatic win on all subsequent rounds following the first

            win = false;

            while (win == false) 
            {
                System.out.println("Guess the number between one and "+ loft + "):: ");
                guess = input.nextInt();
                FORSØG++;
                if (guess == TAL) 
                {

                    win = true;
                }
                    else if (guess < TAL) 
                {
                System.out.println("Colder, guess again!");
                }
                    else if (guess > TAL) {
                    System.out.println("Warmer, guess again!");
                }
            }

            System.out.println("You've found the number!");
            System.out.println("The number was: " + TAL + ".");
            System.out.println("You guessed " + FORSØG + " times.");

            System.out.println("To quit, enter 1.");
            System.out.println("Provide any other input to play again.");

            int userInt = input.nextInt();

            if( userInt == 1)
            {
                keepPlaying = false;
            }
        }
    }
}