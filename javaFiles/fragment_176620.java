public static void main(String[] args) throws IOException {
    Path path = Paths.get("C:\\temp\\test.txt");
    try (Stream<String> stream = Files.lines(path)) {
        stream
            .map(line -> line.split("\\|"))
            .forEach(array -> consumeLine(array[0].trim(), array[1].trim(), array[2].trim()));
    }
}

private static void consumeLine(String s1, String s2, String s3) {
    // Operate on the line
}