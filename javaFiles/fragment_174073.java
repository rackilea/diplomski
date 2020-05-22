interface IoOperation<T> {
    void accept(T item) throws IOException;
    /** Called after successfull completion of <em>all</em> items */
    default void commit() throws IOException {}
    /**
     * Called on failure, for parallel streams it must set the consume()
     * method into a silent state or handle concurrent invocations in
     * some other way
     */
    default void rollback() throws IOException {}
}