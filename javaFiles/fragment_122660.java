// LinkedList<Entry<K, V>> list = table[index]
 for (Entry<K, V> nextItem : table[index]) {
     // iterate over item 1, item 2, item 3 until we find one that is equal.
     if (nextItem.getKey().equals(key)) {
         return nextItem.getValue();
     }
 }