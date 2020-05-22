List<Tile> tiles = ...;

void createTiles() {
    for(int x = 0; x < 100; x++) {
        for(int y = 0; y < 100; y++) {
            Color color = ...; //choose color
            int size = 5;
            int tileX = x * size;
            int tileY = y * size;
            tiles.add(new Tile(tileX, tileY, size, size, color));
        }
    }
}