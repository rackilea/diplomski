Pattern pattern = Pattern.compile("name=\"(.+)\"");
try (BufferedReader reader = Files.newBufferedReader(Paths.get("file.txt"))) {
  return reader.lines()
      .map(pattern::matcher)
      .filter(Matcher::matches)
      .map(m -> m.group(1))
      .findFirst()
      .orElseThrow(IllegalArgumentException::new);
}