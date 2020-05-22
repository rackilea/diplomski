public static <T> Stream<T> myMethod(Stream<T> stream) {
    // for simplification, this does not alter anything from the source stream
    class CustomSpliterator implements Spliterator<T> {
        Spliterator<T> source;
        CustomSpliterator(Spliterator<T> src) {
            source = src;
        }
        @Override public boolean tryAdvance(Consumer<? super T> action) {
            return source.tryAdvance(action);
        }
        @Override public void forEachRemaining(Consumer<? super T> action) {
            source.forEachRemaining(action);
        }
        @Override public Spliterator<T> trySplit() {
            Spliterator<T> sSp = source.trySplit();
            return sSp == null? null: new CustomSpliterator(sSp);
        }
        @Override public long estimateSize() {
            return source.estimateSize();
        }
        @Override public int characteristics() {
            return source.characteristics();
        }
    }
    class MySpSupplier implements Supplier<Spliterator<T>> {
        Stream<T> downStream;
        @Override public Spliterator<T> get() {
            System.out.println("MySpSupplier.get(): nailing down behavior");
            Stream<T> src=downStream.isParallel()? stream.parallel(): stream.sequential();
            return new CustomSpliterator(src.spliterator());
        }
    }
    MySpSupplier sup = new MySpSupplier();
    Stream<T> s = StreamSupport.stream(sup, Spliterator.ORDERED, stream.isParallel());
    sup.downStream = s;
    return s;
}