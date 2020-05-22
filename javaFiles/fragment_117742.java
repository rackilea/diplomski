interface LimitedSet {
    public static final int MAX_VALUES_SIZE = 20;

    byte getSize();
    void setSize(byte);

    MyValue getValue(int index);
    void setValue(@MaxSize(MAX_VALUES_SIZE) int index, MyValue value);
}

...
try (ExternalMapQueryContext<K, LimitedSet, ?> cxt = map.queryContext(key) {
    cxt.writeLock().lock();
    MapEntry<K, LimitedSet> entry = cxt.entry();
    if (entry == null) {
        MapAbsentEntry<K, LimitedSet> absentEntry = cxt.absentEntry();
        cxt.insert(absentEntry, absentEntry.defaultValue());
        entry = cxt.entry();
        assert entry != null;
    }
    LimitedSet values = entry.value().get();
    int size = values.getSize();
    for (int i = 0; i < size; i++) {
        if (same(values.getValue(i), value))
            return false;
    }
    if (size == MAX_VALUES_SIZE)
        throw new IllegalStateException("values set overflow");
    values.set(size, value);
    values.setSize((byte) (size + 1));
}