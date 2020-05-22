// Using streams
public static Set<String> distinctWords(String... input) {
    return Stream.of(input)
            .flatMap(s -> Stream.of(s.split("\\s+")))
            .collect(Collectors.toCollection(() -> new TreeSet<>(String.CASE_INSENSITIVE_ORDER)));
}