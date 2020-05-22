public K lastKey() {
    return key(getLastEntry());
}
final Entry<K,V> getLastEntry() {
    Entry<K,V> p = root;
    if (p != null)
        while (p.right != null)
            p = p.right;
    return p;
}