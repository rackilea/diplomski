Collector.of(
    () -> {
        System.out.printf("%s supplying\n", Thread.currentThread().getName());
        return Collections.synchronizedList(new ArrayList<>());
    },
    (l, o) -> {
        System.out.printf("%s accumulating %s to %s\n", Thread.currentThread().getName(), o, l);
        l.add(o);
    },
    (l1, l2) -> {
        System.out.printf("%s combining %s & %s\n", Thread.currentThread().getName(), l1, l2);
        l1.addAll(l2);
        return l1;
    },
    Characteristics.CONCURRENT,
    Characteristics.UNORDERED
)