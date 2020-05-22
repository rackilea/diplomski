rdd.mapPartitions((Iterator<InObj> iter) -> {
    Iterable<InObj> iterable = () -> iter;
    return StreamSupport.stream(iterable.spliterator(), false)
            .map(s -> transformRow(s)) // or whatever transformation
            .iterator();
});