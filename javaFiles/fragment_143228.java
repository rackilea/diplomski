private static class ComparableValue<T, K extends Comparable<K>> 
                        implements Comparable<ComparableValue<T, K>> {
    final K sortKey;
    final T origValue;

    public ComparableValue(K value, T origValue) {
        this.sortKey = value;
        this.origValue = origValue;
    }

    @Override
    public int compareTo(ComparableValue<T, K> o) {
        return sortKey.compareTo(o.sortKey);
    }
}