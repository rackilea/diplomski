Set<Integer> first = new LinkedHashSet<Integer>(Arrays.asList(2,3,4,5));
Set<Integer> second = new LinkedHashSet<Integer>(Arrays.asList(1,2,3,6));
Set<Integer> addition = subtract(first, second);
Set<Integer> subtracted = subtract( second, first);

public static <T> Set<T> subtract(Set<T> set1, Set<T> set2) {
    Set<T> ret = new LinkedHashSet<T>(set1);
    ret.removeAll(set2);
    return ret;
}