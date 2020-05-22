Stream.of(2,1,1,3,5,6,7,9,2,1,3,5,11,10)
    .peek(i -> System.out.println("source: "+i))
    .distinct()
    .peek(i -> System.out.println("distinct: "+i))
    .filter(i -> i>2)
    .findFirst().ifPresent(i -> System.out.println("found: "+i));