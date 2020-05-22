public class Inventory {
    private static Inventory instance = new Inventory();
    private ArrayList<String> inventory;

    public static Inventory getInstance() {
        return instance;
    }

    // private constructor to prevent extra copies of the inventory
    private Inventory() {
        inventory = new ArrayList<>();
    }

    ...
}