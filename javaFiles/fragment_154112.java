public class Item
{
    public static enum ItemType { FOOD, WEAPON, TOOL, ARMOR; }

    public ItemType type;
    public int weight;

    public Item() {

    }

    public Item(ItemType type, int weight) {
        this.type = type;
        this.weight = weight;
    }
}