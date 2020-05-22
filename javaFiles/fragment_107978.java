public V put(K key, V value) {
        Entry<K,V> t = root;

        if (t == null) {
            incrementSize();
            root = new Entry<K,V>(key, value, null);
            return null;
       }

        while (true) {
            int cmp = compare(key, t.key);
            if (cmp == 0) {
                return t.setValue(value);
            } else if (cmp < 0) {
                if (t.left != null) {
                    t = t.left;
                } else {
                    incrementSize();
                    t.left = new Entry<K,V>(key, value, t);
                    fixAfterInsertion(t.left);
                    return null;
                }
            } else { // cmp > 0
                if (t.right != null) {
                    t = t.right;
                } else {
                    incrementSize();
                    t.right = new Entry<K,V>(key, value, t);
                    fixAfterInsertion(t.right);
                    return null;
                }
            }
        }
    }