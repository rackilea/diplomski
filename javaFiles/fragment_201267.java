public static <TKey, TVal, TCol extends Collection<TVal>> void addToMapOfCollections(Map<TKey, Collection<TVal>> map, TKey key, TVal val, Supplier<TCol> supplier) 
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