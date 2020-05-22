List<String> names = Arrays.asList(
        "25 Jackson 11,693 Nevaeh 6,345",
        "26 Jackson 44,444 Nevaeh 3,56"
);

List<List<String>> words = names.stream()
        .map(sentence -> sentence.split("\\s+"))
        .map(Arrays::asList)
        .collect(Collectors.toList());

words.forEach(System.out::println);