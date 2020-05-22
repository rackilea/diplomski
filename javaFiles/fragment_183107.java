public static <T, AA, A, B, R> Collector<T, ?, R> unorderedBatches(int batchSize,
        Collector<T, AA, B> batchCollector,
        Collector<B, A, R> downstream) {
    return unorderedBatches(batchSize, 
            Collectors.mapping(list -> list.stream().collect(batchCollector), downstream));
}