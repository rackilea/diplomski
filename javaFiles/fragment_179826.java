import java.util.Random; 

public abstract class GameCharacter {

Random rand;

int health;
int attackDamage;

public GameCharacter(int health, int attackDamage){
    rand = new Random();
    this.health = health;
    this.attackDamage = attackDamage;
}

public int attack(){
    return rand.nextInt(attackDamage);
}

public void takeDamage(int damage){
    health -= damage;
}

public int getHealth(){
    return health;
}

public void setHealth(int health){
    this.health = health;
}

public int getDamage(){
    return attackDamage;
}
}