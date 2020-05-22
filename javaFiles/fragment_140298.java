interface IOConsumer<T> extends Consumer<T> {
    public default void accept(T t) {
        try { doIO(t); } catch(IOException ex) { throw new UncheckedIOException(ex); }
    }
    void doIO(T t) throws IOException;

    public static <E> void doForEach(Stream<? extends E> s, IOConsumer<? super E> c)
    throws IOException {
        try{ s.forEachOrdered(c); } catch(UncheckedIOException ex){ throw ex.getCause(); }
    }
}