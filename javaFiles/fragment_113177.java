import java.util.Random;
import java.util.Scanner;

public class Fight {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter your name");
        String you = keyboard.next();
        int youWounds = 1;
        int youTough = 4;
        int youAttack = 1;
        int youWS = 4;
        int youAS = 3;

        String Comp = "Bad Guy";
        int compWounds = 1;
        int compTough = 4;
        int compAttack = 1;
        int compWS = 4;
        int compAS = 3;

        System.out.println(you + ", do you want to FIGHT?!?!?");
        System.out.println("Yes / No?");

        String inputString = keyboard.next();

        if (inputString.equalsIgnoreCase("Yes")) {
            System.out.println("FIGHT!!!!");
            while (youWounds > 0 && compWounds > 0) {

                int youRan = new Random().nextInt(6) + 1; // this is where you roll to hit
                System.out.println(you + " rolls " + youRan + " to hit");

                if (youRan >= 7 - youWS) { // this is the logic for roll to hit
                    System.out.println(you + " hit");

                    int youRanTW = new Random().nextInt(6) + 1; // this is where you check to see if your hit wounds
                    System.out.println(you + " rolls " + youRanTW + " to wound");
                    if (youRanTW > compTough) { // this is the logic for roll to wound
                        System.out.println(you + " wounds" + Comp);
                        compWounds = compWounds - 1; // this is where comp loses a wound
                        if (compWounds <= 0) { // this is the logic for wound loss
                            System.out.println(Comp + " dies!!!");
                        } else {
                            System.out.println("But, " + Comp + " fights on!");
                        }
                    } else {
                        System.out.println(you = " does not wound");
                    }
                } else {
                    System.out.println(you + " misses");
                }

                int compRan = new Random().nextInt(6) + 1;
                System.out.println(Comp + " rolls " + compRan + " to hit");

                if (compRan >= 7 - compWS) { // this is the logic for roll to hit
                    System.out.println(Comp + " hit");
                    int compRanTW = new Random().nextInt(6) + 1; // this is where you check to see if your hit wounds
                    System.out.println(Comp + " rolls " + compRanTW + " to wound");
                    if (compRanTW > youTough) { // this is the logic for roll to wound
                        System.out.println(Comp + " wounds" + you);
                        youWounds = youWounds - 1; // this is where you loses a wound
                        if (youWounds <= 0) { // this is the logic for wound loss
                            System.out.println(you + " dies!!!");
                        } else {
                            System.out.println("But, " + you + " fights on!");
                        }
                    } else {
                        System.out.println(Comp = " does not wound");
                    }
                } else {
                    System.out.println(Comp + " misses");
                }
            }  // REMOVE THE ELSE AND BRACKET
            if (youWounds <= 0) {
                System.out.println(Comp + " WINS!!!!");
            } else {
                System.out.println(you + " WINS!!!!");
            }
            // REMOVE THIS BRACKET
        } else { // this is where i get "Syntax error on tokens, delete these tokens". it wants me to delete "} else".
            System.out.println(you + " you are a looser!!!!!!!!");
        }
        keyboard.close();
    }
}