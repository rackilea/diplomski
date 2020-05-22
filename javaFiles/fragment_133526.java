IntStream istream = ... 
LongAccumulator acc = new LongAccumulator(Long::min, Long.MAX_VALUE);

if (istream.mapToLong(i -> i).peek(acc::accumulate).allMatch(i -> i > N)) {
    System.out.println("min was " + acc.get());
} else {
    System.out.println("a value was <= " + N);
}