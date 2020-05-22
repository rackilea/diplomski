public int compareTo(MyMap<K, V> other) {
    List<K> myKeys = new ArrayList<K>(this.keySet());
    List<K> otherKeys = new ArrayList<K>(other.keySet());
    Collections.sort(myKeys);
    Collections.sort(otherKeys);
    final int minSize = Math.min(myKeys.size(), otherKeys.size());
    for (int i = 0; i < minSize; i++) {
        int cmp = myKeys.get(i).compareTo(otherKeys.get(i));
        if (cmp != 0) {
            return cmp;
        }
    }
    return (myKeys.size() - otherKeys.size());
}