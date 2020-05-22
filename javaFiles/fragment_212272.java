public class PeekingCollector<T,A,R> {
    final Collector<T,A,R> collector;
    final A acc;

    public PeekingCollector(Collector<T,A,R> collector) {
        this.collector = collector;
        this.acc = collector.supplier().get();
    }

    public Consumer<T> peek() {
        if (collector.characteristics().contains(Collector.Characteristics.CONCURRENT))
            return t -> collector.accumulator().accept(acc, t);
        else
            return t -> {
                synchronized (this) {
                    collector.accumulator().accept(acc, t);
                }
            };
    }

    public synchronized R get() {
        return collector.finisher().apply(acc);
    }
}