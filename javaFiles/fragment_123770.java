for(int y = 0;y < chunkHeight;y++) {
    for(int x = 0;x < chunkWidth;x++) {
        //Get the absolute position of the cell.
        int cellX = characterX + x - chunkWidth / 2; //Please check if this is correctly lined out.
        int cellY = characterY + y - chunkHeight / 2;
        if(cellX >= 0 && cellX < mapWidth && cellY >= 0 && cellY < mapHeight) { //Within bounds.
            groundLayer[arrayIndex] = Short.parseShort(strArr[cellX + (cellY * mapWidth)]);
        } else { //Out of bounds, put down a placeholder.
            groundLayer[arrayIndex] = 0;
        }
        arrayIndex++;
    }
}