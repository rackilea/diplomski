public static Vector2 isoToCell(float x, float y) {
    float halfTileWidth = tileWidth * 0.5f;
    float halfTileHeight = tileHeight * 0.5f;

    float row = (1.0/2) * (x/halfTileWidth + y/halfTileHeight);
    float col = (1.0/2) * (x/halfTileWidth - y/halfTileHeight);

    return  new Vector2(row,col);
}