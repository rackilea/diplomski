public static Tile getTile(int xCoord, int yCoord) {
    for (int[] tile : mapTiles) {
        if (tile[Tile.XCOORD] == xCoord && tile[Tile.YCOORD] == yCoord) {
            return new Tile(tile[Tile.XCOORD], tile[Tile.YCOORD], tile[Tile.XLOC], tile[Tile.YLOC], tile[Tile.ISFILLED], tile[Tile.ISVISITED], tile[Tile.ISCURRENT]);
        }
    }
    return null;
}