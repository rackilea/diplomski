public V put(K key, V value) {
    boolean insert = true;
    V prevValue = null;

    for (int i = 0; i < size; i++) {
        if (values[i].getKey().equals(key)) {
            prevValue = values[i].getValue();
            values[i].setValue(value);
            insert = false;
        }
    }

    if (insert) {
        // method for check or increase capacity
        increaseCapacity();
        values[size++] = new HashEntry<K, V>(key, value);
    }

    return prevValue;
}