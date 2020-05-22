final Path file1 = Paths.get("output1.txt");
final Path file2 = Paths.get("output2.txt");

try (
    final BufferedWriter writer1 = Files.newBufferedWriter(file1, StandardCharsets.UTF_8,
        StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    final BufferedWriter writer2 = Files.newBufferedWriter(file2, StandardCharsets.UTF_8,
        StandardOpenOption.CREATE, StandardOpenOption.APPEND);
) {
    // use writer1 and writer2 here.
    // Note that BufferedWriter has a .newLine() method as well.
}