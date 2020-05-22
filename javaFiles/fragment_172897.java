public int getAvailable(final Item item) {
    int count = 0;
    String itemName = item.getItemName();
    for (Map.Entry<Item, Integer> entry : stockItems.entrySet()) {
        Item i = entry.getKey();
        if(itemName.equals(i.getItemName())) {
          count += entry.getValue();
        }
    }
    return count;
}