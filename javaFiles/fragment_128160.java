private static <T> Stream<T> nonEmptyStream(
    Stream<T> stream, Supplier<RuntimeException> e) {

    Spliterator<T> it=stream.spliterator();
    return StreamSupport.stream(new Spliterator<T>() {
        boolean seen;
        public boolean tryAdvance(Consumer<? super T> action) {
            boolean r=it.tryAdvance(action);
            if(!seen && !r) throw e.get();
            seen=true;
            return r;
        }
        public Spliterator<T> trySplit() { return null; }
        public long estimateSize() { return it.estimateSize(); }
        public int characteristics() { return it.characteristics(); }
    }, false);
}