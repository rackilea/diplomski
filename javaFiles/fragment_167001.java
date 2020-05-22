public abstract class Item {
    private int ID;
    private static int IDCounter;
    private String name;

    public Item(String name) {
        this.name = name;
        this.ID = IDCounter;
        IDCounter++;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public abstract void attachToPlayer(Player player);
}

public class Armor extends Item {
    private int life;
    private int res_fire;

    public Armor(String name) {
        super(name);
    }

    @Override
    public void attachToPlayer(Player player) {
       // Only equip if upgrade
        if (player.getArmor().res_fire > this.res_fire)
        player.setArmor(this);

    }

}


public class Weapon extends Item {
    private int dmg_fire;

    public Weapon(String name) {
        super(name);
    }

    // ...stuff

    @Override
    public void attachToPlayer(Player player) {
        // Only equip this if upgrade? You decide the logic
        if(player.getWeapon().dmg_fire>this.dmg_fire)
            player.setWeapon(this);
    }

}

public class SuperSpecialWeapon extends Weapon {
    private float bonusHealthModifier = 1.0f;
    public SuperSpecialWeapon(String name) {
        super(name);
    }

    @Override
    public void attachToPlayer(Player player) {
        // This bonus adds +100%HP bonus to the player!
        int hp = (int) ((1 + bonusHealthModifier) * player.getHealth());
        player.setHealth(hp);
        player.setWeapon(this);
    }

}

public class Potion extends Item {
    private int health = 100;

    public Potion() {
        super("HealthPotion");
    }

    @Override
    public void attachToPlayer(Player player) {
        // If the player has room for one more potion, pick this up
        Potion[] potions = player.getHealthPotions();
        for (int i = 0; i < potions.length; i++) {
            if(potions[i]==null){
                potions[i] = this;
                break;
            }
        }
    }

    // ..other stuff
}