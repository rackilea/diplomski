private List<String> getWordList(List<String>... lists) {
    return Stream.of(lists)
        .flatMap(Collection::stream)
        .flatMap(str -> Arrays.stream(str.split("\\P{L}")))
        .collect(Collectors.toList());
}