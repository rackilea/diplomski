List<String> input = Arrays.asList(
        "aardvark", "crocodile", "antelope",
        "buffalo", "bustard", "cockatoo",
        "capybara", "bison", "alligator");

    PeekingCollector<String,?,Map<String,List<String>>> grouper =
        new PeekingCollector<>(groupingBy(s -> s.substring(0, 1)));

    List<String> output = input.stream()
                               .filter(s -> s.length() > 5)
                               .peek(grouper.peek())
                               .sorted()
                               .collect(toList());

    Map<String,List<String>> groups = grouper.get();
    System.out.println(output);
    System.out.println(groups);