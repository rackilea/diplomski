public List<List<Item>> distribute(List<Item> list, int y, int z) {
    int x = list.size();
    int nLists = (int) Math.ceil((double)x/y);

    // Create result lists
    List<List<Item>> result = new ArrayList<>();
    for (int j = 0; j < nLists; j++)
        result.add(new ArrayList<Item>());
    List<List<Item>> outputLists = new ArrayList<>(result);

    // Create item count store
    Map<Item, Integer> itemCounts = new HashMap<>();
    for (Item item : list)
        itemCounts.put(item, 0);

    // Populate results
    Random random = new Random();
    for (int i = 0; i < x; i++) {
        // Add a random item (from the remaining eligible items)
        // to a random list (from the remaining eligible lists)
        Item item = list.get(random.nextInt(list.size()));
        List<Item> outputList = outputLists.get(random.nextInt(outputLists.size()));
        outputList.add(item);

        // Manage eligible output lists
        if (outputList.size() >= y)
            outputLists.remove(outputList);

        // Manage eligible items
        int itemCount = itemCounts.get(item).intValue() + 1;
        if (itemCount >= z)
            list.remove(item);
        else
            itemCounts.put(item, itemCount);
    }

    return result;
}