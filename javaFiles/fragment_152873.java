import java.util.ArrayList;
import java.util.List;

public class DemoApplication {

    public static void main(String[] args) {
        final List<Item> inventory = new ArrayList<>();

        // Add weapons
        inventory.add(new Weapon("Dagger", 6, 100));
        inventory.add(new Weapon("Longsword", 12, 75));
        inventory.add(new Weapon("Battle Axe", 18, 80));

        // Add armor
        inventory.add(new Armor("Metal helmet", 30, 80));
        inventory.add(new Armor("Leather boots", 10, 80));

        System.out.println("--------------------");
        for (Item item : inventory) {
            item.displayStats();
            System.out.println("--------------------");
        }
    }
}