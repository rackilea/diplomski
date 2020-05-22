int initX = getWidth() / 2 - (columnCount * squareSide) / 2;
int initY = getHeight() / 2 - (rowCount * squareSide) / 2;
int squareCount = rowCount * columnCount;

for(int i = 0; i < squareCount; i++) {
    int rowI = squareCount / rowCount;
    int colJ = squareCount % columnCount;

    //draw at (initX + colJ * squareSide, initY + colI * squareSide)
}