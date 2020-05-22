public static void drawGrid( int x, int y, int rows, int pairs, int size, 
        int offset )
{
    int startingX = x;
    for(int line = 0; line < rows; line++) {
        x = startingX + (line % 2) * offset;
        drawRow(x, y, pairs, size);

        y = y + size + MORTAR;
    }
}