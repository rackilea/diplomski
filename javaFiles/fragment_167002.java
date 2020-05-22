public class Player {
    private Armor armor;
    private Weapon weapon;
    private String name;
    private Potion[] healthPotions = new Potion[10];
    private int health;

    public Player(String name) {
        this.name = name;
    }

    public Armor getArmor() {
        return armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public Potion[] getHealthPotions() {
        return healthPotions;
    }

}