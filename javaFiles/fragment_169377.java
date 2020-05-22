Supplier<Stream<Thing>> stream = () ->
    Stream.of(new Thing(1), new Thing(2), new Thing(3));

Stream<Thing> infinite = repeat(stream);
infinite.limit(50).forEachOrdered(System.out::println);

System.out.println();

Collection<Thing> things =
    Arrays.asList(new Thing(1), new Thing(2), new Thing(3));

Stream<Thing> infinite2 = repeat(things);
infinite2.limit(50).forEachOrdered(System.out::println);