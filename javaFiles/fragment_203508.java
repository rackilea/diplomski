import java.util.*;
   import java.lang.*;

    class GuessDR {

        public static void main(String[] args) {

            System.out.println("Welcome to my number guessing game!");

            int maxnum = 10;

            Random rand = new Random();
            int number = rand.nextInt(maxnum);
            int tries = 0;
            int guess;
            boolean win = false;
            Scanner input = new Scanner(System.in);

            while (win == false) {
                try {

                    System.out.println("Guess a number between 1 and " + maxnum + ": ");
                    guess = input.nextInt();
                    tries++;
                    if (guess == number) {
                        win = true;
                    }

                    else if (guess < number) {
                        System.out.println("Number is to low, tray again");

                    }

                    else if (guess > number) {
                        System.out.println("Number is to high, try again");

                    }

                } catch (InputMismatchException e) {
                    input.nextLine();
                    System.out.println("Enter numerical guess");

                }
            }

            System.out.println("You win!");
            System.out.println("It took you " + tries + " tries.");

        }
    }