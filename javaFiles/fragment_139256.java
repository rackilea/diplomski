public static Square[][] addFromFileToSquareArray(String filePath) {
    Square[][] squares;
    Pattern spaces = Pattern.compile(" ");
    try(Stream<String> stream = Files.lines(Paths.get(filePath))) {
        squares = stream
            .filter(line -> !line.isEmpty())
            .map(line -> spaces.splitAsStream(line)
                .map(Square::squareFor)
                .toArray(Square[]::new) )
            .toArray(Square[][]::new);
    } catch(IOException e) {
        throw new UncheckedIOException(e);
    }
    return squares;
}
static final Map<String,Supplier<Square>> MAP = Map.of(
    "o", SquareOne::new,
    "t", SquareTwo::new,
    "r", SquareThree::new
);
public static Square squareFor(String type) {
    Supplier<Square> s = MAP.get(type);
    if(s == null) throw new IllegalArgumentException("type "+type);
    return s.get();
}