Map<String, List<Item>> itemsByCategory = new LinkedHashMap<String, List<Item>>();
for (Item item : theListOfItems) {
    String category = item.getCategory();
    List<Item> itemsOfCategory = itemsByCategory.get(category);
    if (itemsOfCategory == null) {
        itemsOfCategory = new ArrayList<Item>();
        itemsByCategory.put(category, itemsOfCategory);
    }
    itemsOfCategory.add(item);
}

for (Map.Entry<String, List<Item>> entry : itemsByCategory.entrySet()) {
    System.out.println("Category " + entry.getKey() + ":");
    for (Item item : entry.getValue()) {
        System.out.println("    Item : " + item);
    }
}