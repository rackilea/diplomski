public void put(K key, V value)
{
    int hash = hashFunction(key);
    if (!containsKey(key))
    {
        if(loadFactor() >= MAX_LOAD_FACTOR)
        {
            rehash();
        }
        hash = hashFunction(key);
        while(elementData[hash] != null && !elementData[hash].equals(REMOVED))
        {
                hash = (hash + 1) % elementData.length;
        }
        elementData[hash] = new HashEntry(key, value);
        size++;
    }
    else
    {
        while(elementData[hash] != null && (!elementData[hash].equals(REMOVED) && !elementData[hash].getKey().equals(key)))
        {
            hash = (hash + 1) % elementData.length;
        }
            elementData[hash].value = value;
    }
}