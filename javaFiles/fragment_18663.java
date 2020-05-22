public static <T, A, R> Collector<T, ?, R> collectByIndex(Set<Integer> wantedIndices, 
                                                          Collector<T, A, R> downstream) {
    class Acc {
        int pos;
        A acc = downstream.supplier().get();
    }
    return Collector.of(Acc::new, (acc, t) -> {
        if(wantedIndices.contains(acc.pos++))
            downstream.accumulator().accept(acc.acc, t);
    }, (a, b) -> {throw new UnsupportedOperationException();}, // combining not supported
       acc -> downstream.finisher().apply(acc.acc));
}