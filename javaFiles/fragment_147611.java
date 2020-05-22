public static <T> Collection<T> select(Class<T> c, String sqlStatement) {
    Collection<T> result = new ArrayList<T>();
    /* run sql query using jdbc */
    for ( /* iterate over jdbc results */ ) {
        T item = c.newInstance();
        /* use reﬂection and set all of item’s ﬁelds from sql results */
        result.add(item);
    }
    return result;
}