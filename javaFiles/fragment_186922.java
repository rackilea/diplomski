sizeOf("randoms with size", ThreadLocalRandom.current().ints(1000));
sizeOf("randoms with limit", ThreadLocalRandom.current().ints().limit(1000));
sizeOf("range", IntStream.range(0, 100));
sizeOf("range map", IntStream.range(0, 100).map(i->i));
sizeOf("range filter", IntStream.range(0, 100).filter(i->true));
sizeOf("range limit", IntStream.range(0, 100).limit(10));
sizeOf("generate limit", IntStream.generate(()->42).limit(10));