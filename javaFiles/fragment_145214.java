// Java 6/7
new TreeMap<K, V>(new Comparator<K>() {
    @Override
    public int compare(K lhs, K rhs) {
        return 0;
    }
});

// Java 8+
new TreeMap<K, V>((a, b) -> 0);