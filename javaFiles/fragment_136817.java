public static <Integer extends Comparable<Integer>> int countGreaterThan(Integer [] anArray, Integer elem) {
    int count = 0;
    for (Integer e : anArray) {
        if (e.compareTo(elem) > 0)
            ++count;
        return count;
}