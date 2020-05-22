static List<Pair> getPairs2() throws IOException {
    List<String> lines = Files.readAllLines(Paths.get(FILENAME));
    return IntStream.range(0, lines.size())
                    .parallel()
                    .mapToObj(i -> new Pair(lines.get(i), i+1))
                    .collect(toList());
}