public class Room {

    private Inventory inventory = new Inventory();

    public void addItem(Item item) {
        inventory.addItem(item);
    }

    public void removeItem(Item item) {
        inventory.removeItem(item);
    }
}