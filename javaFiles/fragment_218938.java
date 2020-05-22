public static void main(String... args) {
  Path input = Paths.get("/Users/yourUser/yourInputFile.txt");
  Path output = Paths.get("/Users/yourUser/yourOutputFile.txt");

  try {
   List<String> words = getDistinctSortedWords(input);
   Files.write(output, words, UTF_8);
  } catch (IOException e) {
    //log error and/or warn user
  }
}

private static List<String> getDistinctSortedWords(Path path) throws IOException {
  try(Stream<String> lines = Files.lines(path, UTF_8)) {
    return lines.map(String::trim)
            .filter(s -> !s.isEmpty()) // If keyword is not empty, collect it.
            .distinct()
            .sorted()
            .collect(toList());
  }
}