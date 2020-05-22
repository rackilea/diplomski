static char[][] loadGrid(String line, int width, int height) {
    char grid[][] = new char[height][width];
    int charCount = 0;
    for (int r = 0; r < height; r++) {
        for (int c = 0; c < width; c++) {
            if (charCount < line.length()) {
                grid[r][c] = line.charAt(charCount);
                charCount++;
            }
        }
    }
    return grid;
}