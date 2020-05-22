public static <T extends Comparable<? super T>> int countGreaterThan(T[] anArray, T elem) {
    int count = 0;
    for (T e : anArray) {
        if (e.compareTo(elem) > 0) {
            ++count;
        }
    }
    return count;
}