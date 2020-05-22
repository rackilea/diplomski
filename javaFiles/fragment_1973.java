public static <C, E> C collectValues(Map<?, ? extends Iterable<? extends E>> map, 
                                     Collector<E, ?, C> collector) {
    return map.values().stream()
            .flatMap(iterable -> StreamSupport.stream(iterable.spliterator(), false))
            .collect(collector);
}