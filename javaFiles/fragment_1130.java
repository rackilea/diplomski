public class FilteredKeyCollector<T, K, V> implements Collector<T, Map<K, V>, Map<K, V>> {

    private final Function<? super T,? extends K> keyMapper;
    private final Function<? super T,? extends V> valueMapper;
    private final Predicate<K> keyFilter;
    private final EnumSet<Collector.Characteristics> characteristics;

    private FilteredKeyCollector(Function<? super T,? extends K> keyMapper, Function<? super T,? extends V> valueMapper, Predicate<K> keyFilter) {

        this.keyMapper = keyMapper;
        this.valueMapper = valueMapper;
        this.keyFilter = keyFilter;
        this.characteristics = EnumSet.of(Collector.Characteristics.IDENTITY_FINISH);
    }

    @Override
    public Supplier<Map<K, V>> supplier() {
        return HashMap<K, V>::new;
    }

    @Override
    public BiConsumer<Map<K, V>, T> accumulator() {
        return (map, t) -> {
            K key = keyMapper.apply(t);
            if (keyFilter.test(key)) {
                map.put(key, valueMapper.apply(t));
            }
        };
    }

    @Override
    public BinaryOperator<Map<K, V>> combiner() {
        return (map1, map2) -> {
            map1.putAll(map2);
            return map1;
        };
    }

    @Override
    public Function<Map<K, V>, Map<K, V>> finisher() {
        return m -> m;
    }

    @Override
    public Set<Collector.Characteristics> characteristics() {
        return characteristics;
    }
}