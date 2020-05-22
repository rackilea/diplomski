public void sortBy(int sortOrder) {
    // Step 1: Divide the items into 3 groups
    List<List<MyItem>> groups = Arrays.asList(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    for (MyItem item : list)
        groups.get(item.itemType).add(item);

    // Step 2: Use a string to represent the order (ugly, but works)
    String order = String.valueOf(sortOrder);

    // Step 3: Put the three groups back into the list in the correct order.
    int index = 0;
    for (char c : order.toCharArray())
        for (MyItem item : groups.get(c - '1'))
            list.set(index++, item);
}