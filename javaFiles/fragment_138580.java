boolean matched = IntStream.iterate(1, i -> i + 1)
    .mapToObj(i -> i % 3 == 0 ? "Civic" : i % 7 == 0 ? "Focus" : "Model "+i)
    .peek(System.out::println)
    .filter(model -> model.equals("Civic") || model.equals("Focus"))
    .peek(model -> System.out.println("  After filter:   " + model))
    .distinct()
    .peek(model -> System.out.println("  After distinct: " + model))
    .limit(2)
    .peek(model -> System.out.println("  After limit:    " + model))
    .count() == 2;
System.out.println("Matched = "+matched);