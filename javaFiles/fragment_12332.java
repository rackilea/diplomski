public static <T> Set<T> makeSet(Collection<? extends Collection<T>> a_collection) {
    Iterator<? extends Collection<T>> it = a_collection.iterator();
    Set<T> result = new HashSet<T>();
    while (it.hasNext()) {
            result.addAll(it.next());
    }
    return result;
}