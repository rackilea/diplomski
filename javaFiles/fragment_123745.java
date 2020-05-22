private static int checkAdjacentField(int col, int row, int[][] ae) {
    int nbRows = ae.length;
    int nbCols = ae[0].length;

    // Stream all the 8 positions around your position
    Stream<Point> positions = IntStream.rangeClosed(-1, 1).boxed() // -1, 0, 1
            .map(c -> IntStream.rangeClosed(-1, 1).boxed()         // -1, 0, 1
                    .map(r -> new Point(col+c, row+r)))
            .flatMap(p -> p)                                       // to a list
            .filter(p -> !(p.x == col && p.y==row));               // remove center point

    // then same as first example
    return  positions
            .filter(p -> p.x>=0 && p.y>=0 && p.x<nbCols && p.y<nbRows)
            .mapToInt(p -> ae[p.y][p.x])
            .sorted()
            .findFirst().orElse(-1);
}