static class Item {
    String name;
    int quantity;

    Item(String name, int quantity){
        this.name = name;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object obj) {
        Item i = (Item) obj;
        return this.name.equals(((Item) obj).name) && this.quantity == ((Item) obj).quantity;
    }
}

public static void main(String[] args) {
    Item item1 = new Item("Jacket", 100);
    Item item2 = new Item("Pants", 10);
    Item item3 = new Item("Jacket", 100);

    System.out.println(item1 +".equals(" + item3 + ") " + (item1.equals(item3))); //true
}