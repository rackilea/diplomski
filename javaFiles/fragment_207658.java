class Item implements Comparable<Item> {

    int itemNumber;
    int price;
    String mango;
    String apple;
    String bannana;

    public Item(int itemNumber, int price, String mango, String apple, String bannana) {
        this.itemNumber = itemNumber;
        this.price = price;
        this.mango = mango;
        this.apple = apple;
        this.bannana = bannana;
    }

    //GETTERS

    @Override
    public int compareTo(Item compareItem) {
        int comparePrice = ((Item) compareItem).getPrice();
        //ascending order
        //return this.price - comparePrice;

        //descending order
        return comparePrice - this.price;
    }

}

public static void main(String[] args) {
    List<Item> items = new ArrayList<>();

    //populate the items list by creating an Item for every line you read.
    //Handle null price values
    Collections.sort(items);

    //assuming input is some like 'Mango/purchased/top50'
    String input = "Mango/purchased/top50";
    String[] parts = input.split("/");
    int max = Integer.parseInt(parts[2].substring(3));

    List<Item> result = new ArrayList<>();
    for (int i = 0; i < items.size() && result.size() < max; i++) {
        Item item = items.get(i);
        if ((parts[0].equals("Mango") && item.getMango().equals(parts[1]))
                || (parts[0].equals("Apple") && item.getApple().equals(parts[1]))
                || (parts[0].equals("Bannana") && item.getBannana().equals(parts[1]))) {
            result.add(item);
        }
    }
}