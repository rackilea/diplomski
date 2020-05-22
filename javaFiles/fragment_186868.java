public List<String> readFile() throws IOException {
    List<String> lines = Files.readAllLines(Paths.get("D:/input.txt"));

    List<String> tokens = new ArrayList<>();
    for (String line : lines) {
        Collections.addAll(tokens, line.split(";"));
    }
    return tokens;
}