//import Scanner Class
import java.util.Random;
import java.util.Scanner;

public class JavaMidterm {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        // Create random class object
        Random random = new Random();
        String[] choices = new String[] { "Scissor", "Rock", "Paper" };

        int choice;

        // prompt user
        System.out.print("Scissor (0), rock (1), paper (2): ");
        while (true) {
            try {
                String result = "";
                // read user choice
                choice = Integer.parseInt(s.nextLine());
                if (choice < 0 || choice > 2) {
                    throw new Exception();
                }
                // Generate a random number from 0, 1, 2
                int pick = random.nextInt(3);

                if (choice == pick)
                    result = "It is a draw";
                else if (((choice == 0) && (pick == 2)) || ((choice == 1) && (pick == 0))
                        || ((choice == 2) && (pick == 1)))
                    result = "You won";
                else
                    result = "You lose";

                System.out.println("The computer is " + choices[pick] + ". You are " + choices[choice] + ". " + result);

                System.out.print("Do you want to play again? Yes (0), No (1): ");
                while (true) {
                    try {
                        // read user choice
                        choice = Integer.parseInt(s.nextLine());
                        if (choice < 0 || choice > 1) {
                            throw new Exception();
                        }
                        if (choice == 0)
                            System.out.print("Scissor (0), rock (1), paper (2): ");
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid input.");
                        System.out.print("Do you want to play again? Yes (0), No (1): ");
                    }
                }

                if (choice == 1) {
                    break;
                }

            } catch (Exception e) {
                System.out.println("Invalid input.");
                System.out.print("Scissor (0), rock (1), paper (2): ");
            }
        }
        s.close();
    }
}