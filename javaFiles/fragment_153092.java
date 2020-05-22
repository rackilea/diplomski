Stream.of(1, 4, 2, 5)
    .sorted(Comparator.reverseOrder()); 
    // stream is now [5, 4, 2, 1]

Stream.of("foo", "test", "a")
    .sorted(Comparator.comparingInt(String::length).reversed()); 
    // stream is now [test, foo, a], sorted by descending length