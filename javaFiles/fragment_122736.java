Map<String,Integer> frequencyMap = null;
try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
    frequencyMap = stream
        .map(line -> line.split(PHRASE_SEPARATOR))
        .flatMap(Arrays::stream)
        .map(String::trim)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)));
} catch (IOException e) {
    e.printStackTrace();
}