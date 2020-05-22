List<String> longestWords =
    Files.lines(Paths.get("alice.txt"))
         .collect(Collectors.groupingBy(String::length))
         .entrySet()
         .stream()
         .sorted(Map.Entry.<Integer, List<String>> comparingByKey().reversed())
         .map(Map.Entry::getValue)
         .findFirst()
         .orElse(null);