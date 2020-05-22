protected static boolean box(int box, int d) {
    int boxY = box / 3;
    int boxX = box - (boxY * 3);

    int minX = boxX * 3;
    int maxX = minX + 3;
    int minY = boxY * 3;
    int maxY = maxX + 3;

    for (int y = minY; y < maxY; y++)
        for (int x = minX; x < maxX; x++)
            if (puzzle[x][y] == d) 
                return true;
    return false;
}