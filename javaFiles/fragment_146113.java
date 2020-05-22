public static void main(String[] args) {
    List<Integer> highScore = Arrays.asList(1, 2); // Dummy values
    Path filePath = Paths.get("save_data.txt"); // Your saved data

    // Transform available high scores to a single String using the System line separator to separated the values and afterwards transform the String to bytes ...
    byte[] bytes = highScore.stream().map(Object::toString).collect(Collectors.joining(System.lineSeparator())).getBytes();

    try {
        // Write those high score bytes to a file ...
        Files.write(filePath, bytes, StandardOpenOption.CREATE);
    } catch (IOException e) {
        e.printStackTrace();
    }

    List<String> lines = Collections.emptyList();
    try {
        // Read all available high scores lines from the file ...
        lines = Files.readAllLines(filePath);
    } catch (IOException e) {
        e.printStackTrace();
    }
    int skipLines = Math.max(lines.size() - 3, 0); // You only want the three highest values so we use the line count to determine the amount of values that may be skipped and we make sure that the value may not be negative...

    // Stream through all available lines stored in the file, transform the String objects to Integer objects,  sort them, skip all values except the last three and sort their order descending
    highScore = lines.stream().map(Integer::valueOf).sorted().skip(skipLines).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    // Print the result
    highScore.forEach(System.out::println);
}