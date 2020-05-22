import java.util.*;

public class PlayOffs {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("What is the % chance Team 1 will win (0-100)?: ");
        boolean validNumber;
        int team1input;
        do {
            team1input = scan.nextInt();
            validNumber = team1input >= 0 && team1input <= 100;

            if (!validNumber) {
                System.out.println("That's not between 0-100");
            }

        } while (!validNumber);
        System.out.println("Thank you! Got " + team1input);
    }
}