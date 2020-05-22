public static <T, A, D> Collector<T, ?, D> minAll(Comparator<? super T> comparator, Collector<T, A, D> downstream) {
    return maxAll(comparator.reversed(), downstream);
}

public static <T, A, D> Collector<T, ?, D> maxAll(Comparator<? super T> comparator, Collector<? super T, A, D> downstream) {

    final class PairBox<U, V> {
        public U a;
        public V b;
        PairBox(U a, V b) {
            this.a = a;
            this.b = b;
        }
    }

    Supplier<A> downstreamSupplier = downstream.supplier();
    BiConsumer<A, ? super T> downstreamAccumulator = downstream.accumulator();
    BinaryOperator<A> downstreamCombiner = downstream.combiner();
    Supplier<PairBox<A, T>> supplier = () -> new PairBox<>(downstreamSupplier.get(), null);
    BiConsumer<PairBox<A, T>, T> accumulator = (acc, t) -> {
        if (acc.b == null) {
            downstreamAccumulator.accept(acc.a, t);
            acc.b = t;
        } else {
            int cmp = comparator.compare(t, acc.b);
            if (cmp > 0) {
                acc.a = downstreamSupplier.get();
                acc.b = t;
            }
            if (cmp >= 0)
                downstreamAccumulator.accept(acc.a, t);
        }
    };
    BinaryOperator<PairBox<A, T>> combiner = (acc1, acc2) -> {
        if (acc2.b == null) {
            return acc1;
        }
        if (acc1.b == null) {
            return acc2;
        }
        int cmp = comparator.compare(acc1.b, acc2.b);
        if (cmp > 0) {
            return acc1;
        }
        if (cmp < 0) {
            return acc2;
        }
        acc1.a = downstreamCombiner.apply(acc1.a, acc2.a);
        return acc1;
    };
    Function<PairBox<A, T>, D> finisher = acc -> downstream.finisher().apply(acc.a);
    return Collector.of(supplier, accumulator, combiner, finisher);
}