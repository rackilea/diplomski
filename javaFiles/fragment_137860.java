public static Map<Integer, Long> wordCountByLength(String path) {
    try (Stream<String> lines = Files.lines(Paths.get(path))) {
        return lines.map(l -> l.split(" ")).flatMap(Arrays::stream).filter(s -> !s.isEmpty())
                .collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.counting()));
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}