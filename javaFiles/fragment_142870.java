class Pair<T extends Comparable<T>, U extends Comparable<U>> implements Comparable<Pair<T, U>> {
    public int compare(final Pair<T, U> p1, final Pair<T, U> p2)
    {
        // this first compares the first field. If the first fields are the same, the second fields are compared
        // If you have a different requirement, implement it accordingly.
        return Comparator.comparing(Pair::getFirst).thenComparing(Pair::getSecond).compare(p1, p2);
    }
}