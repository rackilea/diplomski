private Map<String, String> readFileAndConvert(String path) throws IOException {
    String SEPARATOR = ",";
    try (Stream<String> lines = Files.lines(Paths.get(path))) {
      return lines.map(line -> line.split(SEPARATOR))
      .collect(Collectors.toMap(array -> array[0], array -> array[1]));
    }
}