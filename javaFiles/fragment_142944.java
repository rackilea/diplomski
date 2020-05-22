static class Item {
        String name;
        int quantity;

        Item(String name, int quantity){
            this.name = name;
            this.quantity = quantity;
        }
    }
    public static void main(String[] args) {
        Item item1 = new Item("Jacket", 100);
        Item item2 = new Item("Pants", 10);
        Item item3 = new Item("Jacket", 100);

        System.out.println(item1 +"==" + item2 + " " + (item1 == item2)); //false
        System.out.println(item1 +"==" + item3 + " " + (item1 == item3)); //false
    }