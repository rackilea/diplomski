List<String> longestWords =
    Files.lines(Paths.get("alice.txt"))
         .collect(Collectors.groupingBy(String::length))
         .entrySet()
         .stream()
         .max(Map.Entry.comparingByKey())
         .map(Map.Entry::getValue)
         .orElse(null);