public class NestedMap3<K1, K2, K3, V> {

    private final Map<K1, NestedMap2<K2, K3, V>> mK1ToK2ToK3V = 
        new HashMap<K1, NestedMap2<K2, K3, V>>();

    public V put(K1 key1, K2 key2, K3 key3, V value) {
                NestedMap2<K2, K3, V> k2tok3toV = mK1ToK2ToK3V.get(key1);
            if (k2tok3toV == null) {
                k2tok3toV = new NestedMap2<>();
                mK1ToK2ToK3V.put(key1, k2tok3toV);
            }
        return k2tok3toV.put(key2, key3, value);
        }

        public V get(K1 key1, K2 key2, K3 key3) {
                final NestedMap2<K2, K3, V> k2tok3toV = mK1ToK2ToK3V.get(key1);
            if (k2tok3toV == null) {
                return null;
            } else {
                return k2tok3toV.get(key2, key3);
            }
    }

    public Map<K3, V> get(K1 key1, K2 key2) {
        final NestedMap2<K2, K3, V> k2toV = mK1ToK2ToK3V.get(key1);
            if (k2toV == null) {
                return null;
            } else {
                return k2toV.get(key2);
            }
    }

    public NestedMap2<K2, K3, V> get(K1 key1) {
        return mK1ToK2ToK3V.get(key1);
    }

    public Set<K1> keySet() {
        return mK1ToK2ToK3V.keySet();
    }

    public void clear() {
        mK1ToK2ToK3V.clear();
    }
}

public class NestedMap2<K1, K2, V> {

    private final Map<K1, Map<K2, V>> mK1ToK2ToV = new HashMap<K1, Map<K2, V>>();

    public V put(K1 key1, K2 key2, V value) {
    Map<K2, V> k2toV = mK1ToK2ToV.get(key1);
    if (k2toV == null) {
        k2toV = new HashMap<>();
        mK1ToK2ToV.put(key1, k2toV);
    }
    return k2toV.put(key2, value);
    }

    public V get(K1 key1, K2 key2) {
    final Map<K2, V> k2toV = mK1ToK2ToV.get(key1);
    if (k2toV == null) {
        return null;
    } else {
        return k2toV.get(key2);
    }
    }

    public Map<K2,V> get(K1 key1) {
    return mK1ToK2ToV.get(key1);
    }

    public Set<K1> keySet() {
    return mK1ToK2ToV.keySet();
    }

    public Iterable<Pair<K1,K2>> keys2() {
    return new Iterable<Pair<K1,K2>>() {

        @Override
        public Iterator<Pair<K1, K2>> iterator() {
            return new Iterator<Pair<K1,K2>>() {
                private Iterator<Entry<K1, Map<K2, V>>> mIterator1;
                private Entry<K1, Map<K2, V>> mIterator1Object;
                private Iterator<K2> mIterator2;

                {
                    mIterator1 = mK1ToK2ToV.entrySet().iterator();
                    if (mIterator1.hasNext()) {
                        mIterator1Object = mIterator1.next();
                        mIterator2 = mIterator1Object.getValue().keySet().iterator();
                    }
                }

                @Override
                public boolean hasNext() {
                    if (mIterator1Object == null) {
                        return false;
                    } else {
                        return mIterator2.hasNext();
                    }
                }

                @Override
                public Pair<K1, K2> next() {
                    if (mIterator1Object == null) {
                        throw new NoSuchElementException();
                    } else {
                        if (!mIterator2.hasNext()) {
                            if (!mIterator1.hasNext()) {
                                throw new NoSuchElementException();
                            } else {
                                mIterator1Object = mIterator1.next();
                                assert mIterator1Object.getValue().size() > 0 : "must contain at least one value";
                                mIterator2 = mIterator1Object.getValue().keySet().iterator();
                            }
                        }
                        return new Pair<K1, K2>(mIterator1Object.getKey(), mIterator2.next());
                    }
                }
            };
        }
    };

    }

    public Iterable<Triple<K1,K2,V>> entrySet() {
    final ArrayList<Triple<K1,K2,V>> result = new ArrayList<Triple<K1,K2,V>>();
    for (final Entry<K1, Map<K2, V>> entryOuter  : mK1ToK2ToV.entrySet()) {
                for (final Entry<K2, V> entryInner : entryOuter.getValue().entrySet()) {
                    result.add(new Triple<>(entryOuter.getKey(), entryInner.getKey(), entryInner.getValue()));
                }
    }
    return result;
    }

    public void addAll(NestedMap2<K1, K2, V> nestedMap) {
    for (final Triple<K1, K2, V> triple : nestedMap.entrySet()) {
        this.put(triple.getFirst(), triple.getSecond(), triple.getThird());
    }
    }

    public Map<K2, V> remove(K1 k1) {
    return mK1ToK2ToV.remove(k1);
    }

    public V remove(K1 k1, K2 k2) {
        final Map<K2, V> k2ToV = mK1ToK2ToV.get(k1);
    if (k2ToV == null) {
                return null;
    } else {
                return k2ToV.remove(k2);
    }
    }

    @Override
    public String toString() {
            return mK1ToK2ToV.toString();
    }

    public void clear() {
        mK1ToK2ToV.clear();
    }
}