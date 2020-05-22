@SuppressWarnings("unchecked")
static void foo(Object first, Object second) {
    foo((Comparable) first, (Comparable) second);
}

static <T extends Comparable<T>> void foo(T first, T second){
    int diff = first.compareTo(second); // no warning.
}