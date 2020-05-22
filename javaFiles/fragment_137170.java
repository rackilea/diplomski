public class Store {

    // In real life, probably per-item, but keeping it simple here.
    private int inventoryLevel;

    public int getInventoryLevel() { return inventoryLevel; }

    public void setInventoryLevel(int level) {
        this.inventoryLevel = level;
    }

    public void increaseInventoryLevelBy(int amount) {
        this.inventoryLevel += amount;
    }

    public void decreaseInventoryLevelBy(int amount) {
        this.inventoryLevel -= amount;
    }
}