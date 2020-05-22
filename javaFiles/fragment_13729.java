// Remove eldest entry if instructed, else grow capacity if appropriate
        Entry<K,V> eldest = header.after;
        if (removeEldestEntry(eldest)) {
            //This is the standard HashMap remove, which then finishes by
            //calling Map.Entry#remove() on the removed entry.
            removeEntryForKey(eldest.key);
        }


private static class Entry<K,V> extends HashMap.Entry<K,V> {
    // These fields comprise the doubly linked list used for iteration.
    Entry<K,V> before, after;

    /**
     * Removes this entry from the linked list.
     */
    private void remove() {
        before.after = after;
        after.before = before;
    }