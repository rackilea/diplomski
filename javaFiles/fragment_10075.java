public static  <T> Collector<T, AtomicInteger, AtomicInteger> summingInt(ToIntFunction<? super T> mapper) {
  return Collector.of(
      () -> {
        AtomicInteger zero = new AtomicInteger();
        System.out.printf("init [%d (%d)]\n", zero.get(), System.identityHashCode(zero));
        return zero;
      },
      (a, t) -> {
        System.out.printf("-> accumulate [%d (%d)]\n", a.get(), System.identityHashCode(a));
        a.addAndGet(mapper.applyAsInt(t));
        System.out.printf("<- accumulate [%d (%d)]\n", a.get(), System.identityHashCode(a));
      },
      (a, b) -> { a.addAndGet(b.get()); return a;}
  );
}