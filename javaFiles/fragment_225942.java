/**
 * Since we don't use Entry objects, we use the Iterator itself as entry.
 */
private class EntryIterator extends EnumMapIterator<Map.Entry<K,V>>
    implements Map.Entry<K,V>
{
    public Map.Entry<K,V> next() {
        if (!hasNext())
            throw new NoSuchElementException();
        lastReturnedIndex = index++;
        return this;
    }

    public K getKey() {
        checkLastReturnedIndexForEntryUse();
        return keyUniverse[lastReturnedIndex];
    }

    public V getValue() {
        checkLastReturnedIndexForEntryUse();
        return unmaskNull(vals[lastReturnedIndex]);
    }

    public V setValue(V value) {
        checkLastReturnedIndexForEntryUse();
        V oldValue = unmaskNull(vals[lastReturnedIndex]);
        vals[lastReturnedIndex] = maskNull(value);
        return oldValue;
    }

    // equals, hashCode, toString

    private void checkLastReturnedIndexForEntryUse() {
        if (lastReturnedIndex < 0)
            throw new IllegalStateException("Entry was removed");
    }
}