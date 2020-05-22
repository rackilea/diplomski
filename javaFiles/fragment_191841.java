public static <T> Collection<T> getIntersection(Collection<T>... sets) {

    Collection<T> firstSet;

    if (sets == null || sets.length == 0 || (firstSet = sets[0]) == null)
        return Collections.<T>emptySet();

    Collection<T> intersection = new HashSet(firstSet);

    for (Collection c : sets) {
        if (c == null) 
            return Collections.<T>emptySet();
        intersection.retainAll(c);
    }
    return intersection;
}