List<Item> items = new ArrayList<Item>();

String line = null;
while ((line = reader.readLine()) != null) {
    String[] split = line.split(",");

    Item item = new Item(); // New Item is created for every line
    item.name = split[0];
    item.quantity = Integer.valueOf(split[1]);
    item.price = Double.valueOf(split[2]);
    item.total = item.quantity * item.price;

    items.add(item);
}