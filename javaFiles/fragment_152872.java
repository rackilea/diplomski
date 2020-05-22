public class Armor implements Item {

    private final String name;
    private final int protection;
    private int durablity;

    public Armor(String name, int protection, int durablity) {
        this.name = name;
        this.protection = protection;
        this.durablity = durablity;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getProtection() {
        return protection;
    }

    public int getDurablity() {
        return durablity;
    }

    @Override
    public void displayStats() {
        System.out.println("Name: " + name);
        System.out.println("Protection: " + protection);
        System.out.println("Durability: " + durablity);
    }
}