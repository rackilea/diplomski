public static Map<Integer, List<String>> wordsByLength(String file)
        throws IOException {
    return Files.lines(Paths.get(file))
                .flatMap(a -> Arrays.stream(a.split("\\s+")))
                .collect(Collectors.groupingBy(String::length));
}