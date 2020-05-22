<T> T notUsedRandomItem(List<T> allItems, List<T> usedItems) {

    Set<T> used = new HashSet<>(usedItems);
    List<T> all = new ArrayList<>(allItems);

    Collections.shuffle(all);

    for (T item : all) if (!used.contains(item)) return item;

    throw new RuntimeException("Did not find item!");
}