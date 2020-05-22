Path path = Paths.get("path/to/file", "fileName.txt");
try (Stream<String> lines = Files.lines(path)) {
    Map<Integer, Long> wordLengthCount = lines.map(l -> l.split(" ")).flatMap(Arrays::stream)
        .filter(s -> !s.isEmpty())
        .collect(Collectors.groupingBy(w -> w.length(), TreeMap::new, Collectors.counting()));
}