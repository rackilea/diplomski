/* Name of the class has to be "Main" only if the class is public. */
public class Fighter {

    // the Fighter class has three fields
    public int health;
    public int attack;
    public int speed;

    // the Fighter class has one constructor
    public Fighter(int health, int attack, int speed) {
        this.health = health;
        this.attack = attack;
        this.speed = speed;
    }
     // the Figher class has one method, so far...    
    public void roll(double block){
        block = (int)(Math.random() * 100);
    }
}

public class Attacker extends Fighter {

    // the Attacker subclass adds one field
    public int damage;

    // the Attacker subclass has one constructor
    public Attacker(int damage,
                        int health,
                        int attack,
                        int speed) {
        super(health, attack, speed);
        this.damage = damage;
    }   

    // the Attacker subclass adds one method
    public void attacked(int baseDamage){
        // Is human another class , then Fighter or did you mean Figher ? 
        if (super.roll()==block){
             return "Nothing happens";
        }
        else{
          int a = super.roll();
          human.health()-= damage;
        }
        if (super.health > 0){
           System.out.println(health);
        }  
    }
}
}