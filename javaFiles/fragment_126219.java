<T> T notUsedRandomItem(List<T> allItems, List<T> usedItems) {

    Set<T> used = new HashSet<>(usedItems);

    return new Random().ints(allItems.size(), 0, allItems.size())
        .mapToObj(allItems::get)
        .filter(item -> !used.contains(item))
        .findAny()
        .orElseThrow(() -> new RuntimeException("Did not find item!"));
}