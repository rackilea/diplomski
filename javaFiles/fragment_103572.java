public <R, S extends R, T extends R> List<R> listeMischen(List<S> l1, List<T> l2) {
    List<R> newList = new ArrayList<>(l1.size() + l2.size());
    int sizeOfLargerList = Math.max(l1.size(), l2.size());
    for (int i = 0; i < sizeOfLargerList; i++) {
        if (i < l1.size())
            newList.add(l1.get(i));
        if (i < l2.size())
            newList.add(l2.get(i));
    }
    return newList;
}