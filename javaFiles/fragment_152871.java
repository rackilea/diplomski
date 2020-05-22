public class Weapon implements Item {

    private final String name;
    private final int damage;
    private int durability;

    public Weapon(String name, int damage, int durability) {
        this.name = name;
        this.damage = damage;
        this.durability = durability;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public int getDurability() {
        return durability;
    }

    @Override
    public void displayStats() {
        System.out.println("Name: " + name);
        System.out.println("Damage: " + damage);
        System.out.println("Durability: " + durability);
    }
}