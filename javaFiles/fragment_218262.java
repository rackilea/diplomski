String[] arr = new String[]{
        "Hello",
        "world",
        "what",
        "a",
        "fine",
        "day",
        "it",
        "is",
        "the",
        "date",
        "is",
        "01/10/2020"
};

List<Integer> maxRepeatingSizes =
    Arrays.stream(arr)
            .collect(Collectors.groupingBy(
                String::length,
                Collectors.counting()
            )).entrySet()
            .stream()
            .collect(
                    Collectors.groupingBy(
                            Map.Entry::getValue,
                            Collectors.mapping(
                                Map.Entry::getKey,
                                Collectors.toList()
                            )
                    )
            ).entrySet()
            .stream()
            .max(
                    Map.Entry.comparingByKey()
            ).get()
            .getValue();