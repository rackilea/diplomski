public class Rethrowing<T,E extends Throwable> implements Spliterator<T> {
    public static <E extends Throwable, T> Stream<T> translateExceptions(
        Stream<T> source, Class<E> catchType,
        Function<? super E, ? extends RuntimeException> translator) {

        return StreamSupport.stream(new Rethrowing<>(
            source.spliterator(), catchType, translator), source.isParallel());
    }
    private final Spliterator<T> source;
    private final Class<E> catchType;
    private final Function<? super E, ? extends RuntimeException> translator;

    public Rethrowing(Spliterator<T> sp, Class<E> catchType,
            Function<? super E, ? extends RuntimeException> translator) {
        this.source = sp;
        this.catchType = catchType;
        this.translator = translator;
    }
    @Override public boolean tryAdvance(Consumer<? super T> action) {
        try { return source.tryAdvance(action); }
        catch(Throwable t) {
            if(catchType.isInstance(t))
                throw translator.apply(catchType.cast(t));
            else throw t;
        }
    }
    @Override public int characteristics() {
        return source.characteristics();
    }
    @Override public long estimateSize() {
        return source.estimateSize();
    }
    @Override public Spliterator<T> trySplit() {
        Spliterator<T> split = source.trySplit();
        return split==null? null: new Rethrowing<>(split, catchType, translator);
    }
}