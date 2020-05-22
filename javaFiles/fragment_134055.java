package tutorial;

// import java.util.Arrays; // not used
import java.util.Scanner;

public class Tutorial {
    public static void main(String[] args) {

        // Using Scanner class to get in the input from user
        Scanner input = new Scanner(System.in);

        // We initialize our class Kortlek
        Kortlek newKortlek = new Kortlek();

        // initialize the members
        newKortlek.buildCardGame(); 

        // Here we choose a nickname for user:
        System.out.print("Please choose a name: ");
        String Username = input.next();
        String pcName = newKortlek.nickNamePC();


        String userAnswer;
        int userScore = 1;
        int pcScore = 2;
        do {
            System.out.println("You picked up: " + newKortlek.pickCard());
            System.out.println(pcName + " has picked up: "  + newKortlek.pickCard());
            System.out.println("Do you want to continue? write yes or no");
            userAnswer = input.next();

        } while (!userAnswer.equals("no"));
        System.out.println("Your score is: " + userScore);
        System.out.println(pcName + "'s score is: " + pcScore);
    }
}