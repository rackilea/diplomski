public static <T> Set<T> intersect(
        Collection<? extends Collection<T>> sets) {
    if (sets.isEmpty()) return Collections.emptySet();

    Iterator<? extends Collection<T>> it = sets.iterator();
    Set<T> intersect = new HashSet<>(it.next());
    while (it.hasNext()) {
        intersect.retainAll(it.next());
    }
    return intersect;
}