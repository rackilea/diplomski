public static void main(String[] args) {
    // define the input paths and the output path
    Path file01Path = Paths.get("Y:\\our\\path\\to\\file_01.txt");
    Path file02Path = Paths.get("Y:\\our\\path\\to\\file_02.txt");
    Path outputPath = Paths.get("Y:\\our\\path\\to\\result.txt");
    // provide a list for the alternating lines
    List<String> resultLines = new ArrayList<>();

    try {
        // read the lines of both files and get them as lists of Strings
        List<String> linesOfFile01 = Files.readAllLines(file01Path);
        List<String> linesOfFile02 = Files.readAllLines(file02Path);
        // find a common border for the iteration: the size of the bigger list
        int maxSize = (linesOfFile01.size() >= linesOfFile02.size())
                ? linesOfFile01.size() : linesOfFile02.size();

        // then loop and store the lines (if there are any) in a certain order
        for (int i = 0; i < maxSize; i++) {
            // lines of file 01 first
            if (i < linesOfFile01.size()) {
                resultLines.add(linesOfFile01.get(i));
            }
            // lines of file 02 second
            if (i < linesOfFile02.size()) {
                resultLines.add(linesOfFile02.get(i));
            }
        }

        // after all, write the content to the result path
        Files.write(outputPath,
                resultLines,
                Charset.defaultCharset(),
                StandardOpenOption.CREATE_NEW);
    } catch (IOException e) {
        System.err.println("Some files system operation failed:");
        e.printStackTrace();
    }
}