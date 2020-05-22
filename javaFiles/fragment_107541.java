package okekpejmoropinzee;

import java.util.Random;
import java.util.Scanner;

public class OkekpeJMoropinzee {
     static boolean playAgain = true;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        while (playAgain == true) {
            playGame(input);
        }

        System.out.println("Thanks for playing");
        input.close();
    }

    private static void playGame(Scanner input) {
        String yourMove = "", compMove = "";
        int compInt = 0;
        String gameCharacters = "Monkey Robot Pirate Ninja Zombie";

        Random rand = new Random();
        compInt = rand.nextInt(5)+1;

        if (compInt == 1) { compMove = "Monkey"; }
        else if (compInt == 2) { compMove = "Robot"; }
        else if (compInt == 3) { compMove = "Pirate"; }
        else if (compInt == 4) { compMove = "Ninja"; }
        else if (compInt == 5) { compMove = "Zombie"; }
        System.out.println(compMove + " --- " + compInt);

        yourMove = "";
        while (yourMove.equals("")) {
            System.out.println("What do you choose? --> "); 
            yourMove = input.nextLine().toLowerCase();
            if (yourMove.equals("quit")) { 
                System.out.println("Thanks for playing. Bye Bye"); 
                System.exit(0); 
            }
            if (!gameCharacters.toLowerCase().contains(yourMove) || yourMove.equals("")) {
                System.out.println("You entered an invalid Game Character! Try again...\n"); 
                continue;
            }
        }

        //MONKEY
        if (yourMove.equals("monkey") && compInt == 1) { 
            System.out.println("Tie"); 
        }
        else if (yourMove.equals("monkey") && compInt == 2) { 
            System.out.println("You Win! Monkey Unplugs Robot!"); 
        }
        else if (yourMove.equals("monkey") && compInt == 3) { 
            System.out.println("You Lose! Pirate Skewers Monkey!"); 
        }
        else if (yourMove.equals("monkey") && compInt == 4) { 
            System.out.println("You Win! Monkey fools Ninja!"); 
        }
        else if (yourMove.equals("monkey") && compInt == 5) { 
            System.out.println("You Lose! Zombie savages monkey!"); 
        }

        //ROBOT
        else if (yourMove.equals("robot") && compInt == 2) { 
            System.out.println("Tie"); 
        }
        else if (yourMove.equals("robot") && compInt == 1) { 
            System.out.println("You Lose! Monkey Unplugs Robot!"); 
        }
        else if (yourMove.equals("robot") && compInt == 3) { 
            System.out.println("You Lose! Pirate Drowns Robot!!"); 
        }
        else if (yourMove.equals("robot") && compInt == 4) { 
            System.out.println("You Win! Robot Chokes Ninja"); 
        }
        else if (yourMove.equals("robot") && compInt == 5) { 
            System.out.println("You win! Robot Crushes Zombie!"); 
        }

        //PIRATE
        else if (yourMove.equals("pirate") && compInt == 3) { 
            System.out.println("Tie"); 
        }
        else if (yourMove.equals("pirate") && compInt == 1) { 
            System.out.println("You Win! Pirate Skewers Monkey!"); 
        }
        else if (yourMove.equals("pirate") && compInt == 2) { 
            System.out.println("You Win! Pirate Drowns Robot!"); 
        }
        else if (yourMove.equals("pirate") && compInt == 4) { 
            System.out.println("You Lose! Ninja Karate Chops Pirate!"); 
        }
        else if (yourMove.equals("pirate") && compInt == 5) { 
            System.out.println("You Lose! Zombie Eats Pirate!"); 
        }

        //NINJA
        else if(yourMove.equals("ninja") && compInt == 4) { 
            System.out.println("Tie"); 
        }
        else if (yourMove.equals("ninja") && compInt == 1) { 
            System.out.println("You Lose! Monkey Fools Ninja!"); 
        }
        else if (yourMove.equals("ninja") && compInt == 2) { 
            System.out.println("You Lose! Robot Chokes Ninja!"); 
        }
        else if (yourMove.equals("ninja") && compInt == 3) { 
            System.out.println("You Win! Ninja Karate Chops Pirate!"); 
        }
        else if (yourMove.equals("ninja") && compInt == 5) { 
            System.out.println("You Win! Ninja Decapitates Zombie!"); 
        }

        //ZOMBIE
        else if(yourMove.equals("zombie") && compInt == 5) { 
            System.out.println("Tie"); 
        }
        else if (yourMove.equals("zombie") && compInt == 1) { 
            System.out.println("You Win! Zombie Savages Monkey!"); 
        }
        else if (yourMove.equals("zombie") && compInt == 2) { 
            System.out.println("You Lose! Robot Crushes Zombie!"); 
        }
        else if (yourMove.equals("zombie") && compInt==3) { 
            System.out.println("You Win! Zombie Eats Pirate!"); 
        }
        else if (yourMove.equals("zombie") && compInt==4) { 
            System.out.println("You Lose! Ninja Decapitates Zombie!"); 
        }

        //Ask if User wants to play the game again...
        String playMore = "";
        while (!playMore.equals("y") && !playMore.equals("n")) {
            System.out.println("\nDo you want to play another game? (y/n) ");
            playMore = input.nextLine().toLowerCase();
        }
        if (playMore.equals("n")) { playAgain = false; }
    }
}