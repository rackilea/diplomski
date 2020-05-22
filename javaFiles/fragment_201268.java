public static <TKey, TVal> void addToMapOfCollections(Map<TKey, Collection<TVal>> map, TKey key, TVal val, Supplier<Collection<TVal>> supplier)
{
    Collection<TVal> col = map.get(key);
    if (col == null) {
        col = supplier.get ();
        col.add(val);
        map.put(key, col);
    } else {
        col.add(val);
    }
}