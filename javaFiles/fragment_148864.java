List<Integer> getItemIds(List<Item> items) {
    List<Integer> itemIds = new ArrayList<>();
    for(Item item : items) {
       itemIds.add(item.getItemID());
    }
 return itemIds;
}