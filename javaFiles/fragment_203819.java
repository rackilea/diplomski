Stream<String> result = cartesian(
          (a, b) -> a + b, 
          () -> Stream.of("A", "B"), 
          () -> Stream.of("K", "L"), 
          () -> Stream.of("X", "Y")
        );
result.forEach(System.out::println);