import java.util.Scanner; 
import java.util.Random; 

public class DungeonGame {

Random rand;
Scanner in; 

Player player;
private int healthPotionDropChance;
boolean running;

public static void main (String[] args){

    DungeonGame game = new DungeonGame();
    game.run();
    System.out.println("###############################");
    System.out.println("Thanks for playing!");
    System.out.println("###############################");

}

public DungeonGame(){
    // System Objects
    in = new Scanner(System.in);
    rand = new Random(); 

    System.out.println("Welcome to the Dungeon Game!"); //Welcome Message

    player = new Player();
    healthPotionDropChance = 50;

}

public void run(){
    running = true;
    GAME:
    while (running) {
        System.out.println("---------------------------------------------");

        /*int enemyHealth = rand.nextInt(maxEnemyHealth); // Get a random health for enemy (How strong is the enemy?)
        String enemy = enemies[rand.nextInt(enemies.length)]; //Set random enemy from array
        System.out.println("\t#" + enemy + " appeared! #\n");
        //           # Skelenton has appeared (example)
        */
        Enemy enemy = new Enemy();
        String enemyType = enemy.getType();
        System.out.println("\t#" + enemyType + " appeared! #\n");

        while(enemy.getHealth() > 0) {

            System.out.println("\tYour HP: " + player.getHealth());
            System.out.println("\t+" + enemyType + "'s HP: " + enemy.getHealth());
            System.out.println("\n\tWhat would you like to do?");
            System.out.println("\t1. Attack");
            System.out.println("\t2. Drink health potion");
            System.out.println("\t3. Run!");

            String input = in.nextLine(); 
            if(input.equals("1")){

                int damageTaken = enemy.attack();
                int damageProduced = player.attack();

                enemy.takeDamage(damageProduced);
                player.takeDamage(damageTaken);

                System.out.println("\t> You strike the " + enemyType + " for " + damageProduced + " damage."); 
                System.out.println("\t> You receive " + damageTaken + " in retaliation!"); 

                if(player.getHealth() < 1) {

                    System.out.println(">t You have taken too much damage, you are to weak to go on!");
                    break; 
                }


            }

            else if (input.equals("2")){
                if(player.getNumHealthPotions() > 0) {

                    player.applyPotion();
                    System.out.println("\t> You drink a health potion, healing yourself for " + player.getHealthPotionHealAmount() + "."
                                        + "\n\t> You now have" + player.getHealth() + "HP."
                                        + "\n\t> You have" + player.getNumHealthPotions() + "health potions left.\n"); 

                }

                else {
                    System.out.println("\t> You have no health potions left!! Defeat enemies for a chance to get one. \n"); 
                    }

                }


           else if(input.equals("3")){
               System.out.println("\tYou run away from the " + enemyType + "!");
               continue GAME; 




            }

            else {

                System.out.println("\tInvalid Command!");

            }

        }

        if(player.getHealth() < 1) {

            System.out.println("You limp out of the dungeon, weak from battle.");
            break; 
        }


        System.out.println("---------------------------------------------");
        System.out.println(" # " + enemyType + " was defeated! #"); 
        System.out.println(" # You have " + player.getHealth() + " HP left. #");
        if(rand.nextInt(100) < healthPotionDropChance) {

            player.pickUpHealthPotion();
            System.out.println(" # The " + enemyType + " dropped a health potion! #");
            System.out.println(" # You now have " + player.getNumHealthPotions() + "health potion(s). # ");


        }
        System.out.println("---------------------------------------------");
        System.out.println("What would you like to do now?");
        System.out.println("1. Continue fighting");
        System.out.println("2. Exit game");

        String input = in.nextLine();

        while(!input.equals("1") && !input.equals("2")) {
            System.out.println("invalid Command!");
            input = in.nextLine(); 
        }

        if(input.equals("1")) {

            System.out.println("You continue on your adventure!");
        }

        else if (input.equals("2")) {
            System.out.println("You exit the dungeon, successful from your adventures!"); 
            break;
        }
    }
}

}