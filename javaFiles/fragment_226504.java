private void writeObject(java.io.ObjectOutputStream s)
    throws java.io.IOException
{
    // Write out the key type and any hidden stuff
    s.defaultWriteObject();

    // Write out size (number of Mappings)
    s.writeInt(size);

    // Write out keys and values (alternating)
    for (Map.Entry<K,V> e :  entrySet()) {
        s.writeObject(e.getKey());
        s.writeObject(e.getValue());
    }
}

private void readObject(java.io.ObjectInputStream s)
    throws java.io.IOException, ClassNotFoundException
{
    // Read in the key type and any hidden stuff
    s.defaultReadObject();

    keyUniverse = getKeyUniverse(keyType);
    vals = new Object[keyUniverse.length];

    // Read in size (number of Mappings)
    int size = s.readInt();

    // Read the keys and values, and put the mappings in the HashMap
    for (int i = 0; i < size; i++) {
        K key = (K) s.readObject();
        V value = (V) s.readObject();
        put(key, value);
    }
}