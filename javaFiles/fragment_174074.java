public static <T> void processAllAtems(Stream<T> s, IoOperation<? super T> c) 
throws IOException {
    Consumer<IoOperation> rollback=io(IoOperation::rollback);
    AtomicBoolean success=new AtomicBoolean();
    try(Stream<T> s0=s.onClose(() -> { if(!success.get()) rollback.accept(c); })) {
        s0.forEach(io(c));
        c.commit();
        success.set(true);
    }
    catch(UncheckedIOException ex) { throw ex.getCause(); }
}
private static <T> Consumer<T> io(IoOperation<T> c) {
    return item -> {
        try { c.accept(item); }
        catch (IOException ex) { throw new UncheckedIOException(ex); }
    };
}