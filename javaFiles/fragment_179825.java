public class Enemy extends GameCharacter{

private String[] enemies = {"Skeleton", "Zombie", "Warrior", "Assassin"}; 
private String type;
private int maxHealth; 
private int health;
private int attackDamage; 

public Enemy(){
    //generates a random enemy
    super(100,25);
    maxHealth = 75;
    attackDamage = 25;
    type = enemies[rand.nextInt(enemies.length)]; //Set random enemy from array
    health = rand.nextInt(maxHealth);

}

public String getType(){
    return type;
}

}