public static <T> int chainedCompare(T object1, T object2, Comparator<T>... comparators) {
    int compareValue = 0;
    for (Comparator<? super T> comparator : comparators) {
        compareValue = comparator.compare(object1, object2);
        if (compareValue != 0)
            break;
    }
    return compareValue;
}