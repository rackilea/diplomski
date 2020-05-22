// When it's an inner class
public Iterator<Pair<K,T>> iterator() {
    return new BSTMapIter(this.root, this.size, this.order);
}

// When it's a standalone generic class
public Iterator<Pair<K,T>> iterator() {
    return new BSTMapIter<K, T>(this.root, this.size, this.order);
}