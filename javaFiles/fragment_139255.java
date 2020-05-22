public static Square[][] addFromFileToSquareArray(String filePath) {
    Square[][] squares;
    try(Stream<String> stream = Files.lines(Paths.get(filePath))) {
        squares = stream
            .filter(line -> !line.isEmpty())
            .map(line -> line.chars()
                .filter(ch -> ch != ' ')
                .mapToObj(Square::squareFor)
                .toArray(Square[]::new) )
            .toArray(Square[][]::new);
    } catch(IOException e) {
        throw new UncheckedIOException(e);
    }
    return squares;
}