Map<
    Tuple2<Integer, Integer>,
    Optional<BigDecimal>
> map =
Seq.of(
    new A(1, new BigDecimal("1.01"), 1, 1),
    new A(1, new BigDecimal("2.09"), 3, 1),
    new A(1, new BigDecimal("8"), 6, 1),
    new A(2, new BigDecimal("119"), 7, 2),
    new A(1, new BigDecimal("3.01"), 4, 1),
    new A(1, new BigDecimal("4"), 4, 1),
    new A(1, new BigDecimal("5"), 5, 1))
.groupBy(
    t -> tuple(t.z, t.w),
    Agg.sum(t -> t.x)
);

map.entrySet().forEach(t-> {
    System.out.println(String.format("w=%s, z=%s, sumX=%s", t.getKey().v1, t.getKey().v2,
            t.getValue().orElse(BigDecimal.ZERO)));
});