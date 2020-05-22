private static int checkAdjacentField(int col, int row, int[][] ae) {
    int nbRows = ae.length;
    int nbCols = ae[0].length;

    // Stream all the 8 positions around your position
    Stream<Point> positions = Stream.of(       
            new Point(col-1, row-1), new Point(col-1, row), new Point(col-1, row+1),
            new Point(col, row-1), new Point(col, row+1),
            new Point(col+1, row-1), new Point(col+1, row), new Point(col+1, row+1));

    return positions
            .filter(p -> p.x>=0 && p.y>=0 && p.x<nbCols && p.y<nbRows)   // keep those inbound
            .mapToInt(p -> ae[p.y][p.x])      // replace positions by their values in the array
            .sorted()                         // sort the values
            .findFirst().orElse(-1);          // take the first one (smallest) 
}