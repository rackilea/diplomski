public class Player extends GameCharacter {

private int numHealthPotions;   // Number of health pots our player is set with
private int healthPotionHealAmount;  // Amount a health the pot will raise
private int healthPotionDropChance;

public Player(){
    super(100,50);
    numHealthPotions = 3;
    healthPotionHealAmount = 30; 
}

public void applyPotion(){
    health += healthPotionHealAmount;
    numHealthPotions--;
}

public void pickUpHealthPotion(){
    numHealthPotions++;
}

public int getNumHealthPotions(){
    return numHealthPotions;
}

public int getHealthPotionHealAmount(){
    return healthPotionHealAmount;
}
}