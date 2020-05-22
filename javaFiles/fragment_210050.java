public class MyLinkedHashMap<K,V> extends LinkedHashMap<K,V> {
    BigInteger mySize;

    @Override
    public V put(K key, V Value) {
        if (super.put(key,value) == null) // this will still eventually throw an exception because of the 'size' variable incrementing internally in the HashMap
            mySize.add(BigInteger.ONE);
    }

    @Override
    public V remove(Object key) {
        if (super.remove(key) != null)
            mySize.subtract(BigInteger.ONE);
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException();
    }        

    public BigInteger getSize() {
        return mySize;
    }
}