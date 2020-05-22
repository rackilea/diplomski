@SuppressWarnings("unchecked")
public static <E> E getTreeRoot(TreeSet<E> ts) {
    try {
        Field mField = TreeSet.class.getDeclaredField("m");
        mField.setAccessible(true);
        return getTreeRoot((TreeMap<E, Object>) mField.get(ts));
    } catch (NoSuchFieldException | IllegalAccessException e) {
        throw new IllegalStateException("Internals of TreeSet has changed", e);
    }
}

@SuppressWarnings("unchecked")
public static <K,V> K getTreeRoot(TreeMap<K,V> tm) {
    try {
        Field rootField = TreeMap.class.getDeclaredField("root");
        rootField.setAccessible(true);
        Map.Entry<K,V> root = (Map.Entry<K,V>) rootField.get(tm);
        return (root == null ? null : root.getKey());
    } catch (NoSuchFieldException | IllegalAccessException e) {
        throw new IllegalStateException("Internals of TreeMap has changed", e);
    }
}