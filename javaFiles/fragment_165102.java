Stream<Integer> stream = Stream.of(2,1,3,5,3)
    .peek(i -> System.out.println("source: "+i))
    .distinct()
    .peek(i -> System.out.println("distinct: "+i))
    .sorted()
    .peek(i -> System.out.println("sorted: "+i));
System.out.println("commencing terminal operation");
stream.forEachOrdered(i -> System.out.println("terminal: "+i));