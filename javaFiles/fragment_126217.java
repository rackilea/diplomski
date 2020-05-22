<T> T notUsedRandomItem(List<T> allItems, List<T> usedItems) {

    Set<T> used = new HashSet<>(usedItems);
    Set<T> all = new HashSet<>(allItems);

    all.removeIf(used::contains); // or all.removeAll(used)

    if (all.isEmpty()) throw new RuntimeException("Did not find item!");

    int skip = new Random().nextInt(all.size());
    Iterator<T> it = all.iterator();
    for (int i = 0; i < skip; i++) it.next();

    return it.next();
}