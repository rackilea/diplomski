private Stream<String> readAllLines(Path path) {
    try (Stream<String> fileContent = Files.lines(path)) {
        return fileContent;
    } catch (IOException e) {
        e.printStackTrace();
    }
    return null;
}