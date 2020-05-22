public V retrieve(K key) {
    // iterating on each element of the list would suffice to check if a key exists in the list 
    for (Pair<K, V> pair : set_of_pairs) { // iterating on list of 'Pair's
        if (pair.getKey().equals(key)) {  // 'equals' instead of ==
            return pair.getValue();
        }
    }
    return null;
}