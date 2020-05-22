public class MoreCollectors
{
    public static <T, K, U> Collector<T, ?, Map<K,U>> toLinkedMap(
        Function<? super T, ? extends K> keyMapper,
        Function<? super T, ? extends U> valueMapper)
    {
        return Collectors.toMap(
            keyMapper,
            valueMapper, 
            (u, v) -> {
                throw new IllegalStateException(String.format("Duplicate key %s", u));
            },
            LinkedHashMap::new
        );
    }
}