public static <T>
Collector<T, ?, List<T>> toList() {
    return new CollectorImpl<>((Supplier<List<T>>) ArrayList::new, List::add,
                               (left, right) -> { left.addAll(right); return left; },
                               CH_ID);
}

// ...

static final Set<Collector.Characteristics> CH_ID
        = Collections.unmodifiableSet(EnumSet.of(Collector.Characteristics.IDENTITY_FINISH));