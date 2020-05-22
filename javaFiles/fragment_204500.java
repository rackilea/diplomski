public static <T> List<T> reverseList(List<T> l) {
    int endIndex = l.size() - 1;
    int midPoint = endIndex/2;
    for (int i = endIndex; i > midPoint; i-- ) {
        T temp = l.get(i);
        int distanceFromEndIndex = endIndex - i;
        l.set(i, l.get(distanceFromEndIndex));
        l.set(distanceFromEndIndex, temp);
    }
    return l;
}