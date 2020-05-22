public class Item implements Comparable<Item> {

    String id = null;

    public Item(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public int compareTo(Item o) {
        return - id.compareToIgnoreCase(o.id);
    }
}


public class Inventory {

    List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addItem(new Item("2"));
        inventory.addItem(new Item("4"));
        inventory.addItem(new Item("1"));
        inventory.addItem(new Item("7"));

        Collections.sort(inventory.items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.id.compareToIgnoreCase(o2.id);
            }
        });
        System.out.println(inventory.items);

        Collections.sort(inventory.items);
        System.out.println(inventory.items);

    }
}