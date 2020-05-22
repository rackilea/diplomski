public static <T, K, U> Collector<T, ?, Map<K,U>> toMap(
    Function<? super T, ? extends K> keyMapper, 
    Function<? super T, ? extends U> valueMapper) 
{
    return toMap(keyMapper, valueMapper, throwingMerger(), HashMap::new);
}