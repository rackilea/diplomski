String s = Stream.of(1, 2, 3, 4).parallel()
            .unordered()
            .collect(
                    Collector.of(
                            () -> new ConcurrentLinkedQueue<>(),
                            (c, e) -> c.add(e.toString()),
                            (c1, c2) -> {
                                c1.addAll(c2);
                                return c1;
                            },
                            Characteristics.CONCURRENT))