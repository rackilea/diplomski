static <R> List<R> listeMischen(List<? extends R> l1, List<? extends R> l2) {
    if (!(l1 instanceof RandomAccess && l2 instanceof RandomAccess))
        return listeMischen((Iterable<? extends R>) l1, (Iterable<? extends R>) l2);

    // Preallocate with known exact required capacity
    List<R> newList = new ArrayList<>(l1.size() + l2.size());
    int sizeOfSmallerList = Math.min(l1.size(), l2.size());
    int i;
    // Zip the lists up to common maximum index
    for (i = 0; i < sizeOfSmallerList; i++) {
        newList.add(l1.get(i));
        newList.add(l2.get(i));
    }
    // Add any remaining items from one or the other list
    for (; i < l1.size(); i++)
        newList.add(l1.get(i));
    for (; i < l2.size(); i++)
        newList.add(l2.get(i));
    return newList;
}

static <R> List<R> listeMischen(Iterable<? extends R> l1, Iterable<? extends R> l2) {
    List<R> newList = new ArrayList<>();
    Iterator<? extends R> it1 = l1.iterator();
    Iterator<? extends R> it2 = l2.iterator();
    // Zip the lists up to common maximum index
    while (it1.hasNext() && it2.hasNext()) {
        newList.add(it1.next());
        newList.add(it2.next());
    }
    // Add any remaining items from one or the other lists
    it1.forEachRemaining(newList::add);
    it2.forEachRemaining(newList::add);
    return newList;
}