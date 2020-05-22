public static void drawRow( int x, int y, int pairs, int size ) {
    // loop for each pair.
    for (int i = 0; i < pairs; i++) {
        StdDraw.setPenColor(Color.BLACK);
        // Note the correct centering of the rectangles
        StdDraw.filledRectangle(x + size/2, y + size/2, size / 2, size/2);
        StdDraw.setPenColor(Color.BLUE);
        StdDraw.line(x, y, x+size, y+size);
        StdDraw.line(x, y+size, x+size, y);
        StdDraw.setPenColor(Color.WHITE);
        // Note the correct centering of the rectangles
        StdDraw.filledRectangle(x+size+size/2, y + size/2, size / 2, size/2);
        // advance to the next pair.
        x += size * 2;
    }
}