final Map<String, List<String>> inputMap = new HashMap<>();
inputMap.put("Fruit", asList("apple", "orange"));
inputMap.put("Animal", asList("cat", "dog"));

final List<String> list = asList("apple", "dog", "cat");

final Map<String, List<String>> outputMap = inputMap.entrySet().stream()
        .filter(e -> e.getValue().stream().anyMatch(list::contains))
        .collect(toMap(e -> e.getKey(), e -> e.getValue().stream().filter(list::contains).collect(toList())));

outputMap.forEach((k, v) -> System.out.printf("%s: %s%n", k, v));