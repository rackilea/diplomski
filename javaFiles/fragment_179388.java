// assuming x <= 8 and y <= 8
int firstCol = ((8-x) / tileSize);
int firstRow = ((8-y) / tileSize);
int lastCol = firstCol + ((Panel.WIDTH + tileSize - 1) / tileSize); // Panel.WIDTH/tileSize, but rounding up
int lastRow = firstRow + ((Panel.HEIGHT + tileSize - 1) / tileSize);

for(int row = lastRow; row <= firstRow; row++) {
    for(int col = lastCol; col <= firstCol; col++) {
        // drawing code goes here
        // there's no need to test the tile is onscreen inside the loop
    }
}