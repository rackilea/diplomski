private List<String[]> savefromfile(String filePath) throws IOException {
    try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
        return lines
            .map(line -> line.trim().split("\\s+"))
            .collect(Collectors.toCollection(LinkedList::new));
    }
}