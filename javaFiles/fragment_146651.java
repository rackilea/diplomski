private static <T> Collection<Collection<T>> splitCollection(Collection<T> c, int partitionSize) {
    List<Collection<T>> result = new ArrayList<>();
    List<T> partition = new ArrayList<>();
    for (T o : c) {
        if (partition.size() == partitionSize) {
            result.add(partition);
            partition = new ArrayList<>();
        }
        partition.add(o);
    }
    if (!partition.isEmpty()) {
        result.add(partition);
    }
    return result;
}