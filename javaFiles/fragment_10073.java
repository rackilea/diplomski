public static  <T> Collector<T, Integer, Integer> summingInt(ToIntFunction<? super T> mapper) {
  return Collector.of(
      () -> {
        Integer zero = 0;
        System.out.printf("init [%d (%d)]\n", zero, System.identityHashCode(zero));
        return zero;
      },
      (a, t) -> {
        System.out.printf("-> accumulate [%d (%d)]\n", a, System.identityHashCode(a));
        a += mapper.applyAsInt(t);
        System.out.printf("<- accumulate [%d (%d)]\n", a, System.identityHashCode(a));
      },
      (a, b) -> a += b,
      a -> a
  );
}