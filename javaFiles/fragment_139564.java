List<Pair> getPairs1() throws IOException {
    AtomicInteger counter = new AtomicInteger(0);
    try (Stream<String> lines = Files.lines(Paths.get(FILENAME))) {
        return lines.parallel()
                    .map(line -> new Pair(line, counter.incrementAndGet()))
                    .collect(toList());
    }
}