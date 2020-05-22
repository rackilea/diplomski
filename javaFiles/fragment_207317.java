HashIterator() {
        expectedModCount = modCount;
        Node<K,V>[] t = table;
        current = next = null;
        index = 0;
        if (t != null && size > 0) { // advance to first entry
--->        do {} while (index < t.length && (next = t[index++]) == null);
        }
    }