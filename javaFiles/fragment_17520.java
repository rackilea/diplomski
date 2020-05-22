public static <E extends Comparable<E>> E max(List<E> list) {
    Iterator<E> iterator = list.iterator();
    E maximum = iterator.next();
    while (iterator.hasNext()) {
        E x = iterator.next();
        if (maximum.compareTo(x) < 0) {
            maximum = x;
        }
    }
    return maximum;
}