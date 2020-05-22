public class CountComparator<T> implements Comparator<T> {
    private Map<T, Integer> counts;

    public CountComparator(Map<T, Integer> counts) {
        this.counts = counts;
    }

    public int compare(T o1, T o2) {
        // assumes that the map contains all keys
        return counts.get(o1).compareTo(counts.get(o2));
    }
}