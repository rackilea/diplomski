public void render(int x, int y, int sx, int sy, int width, int ty,
        boolean lineByLine, int mapTileWidth, int mapTileHeight) {
    for (int tileset = 0; tileset < map.getTileSetCount(); tileset++) {
        TileSet set = null;

        for (int tx = 0; tx < width; tx++) {
            if ((sx + tx < 0) || (sy + ty < 0)) {
                continue;
            }
            if ((sx + tx >= this.width) || (sy + ty >= this.height)) {
                continue;
            }

            if (data[sx + tx][sy + ty][0] == tileset) {
                if (set == null) {
                    set = map.getTileSet(tileset);
                    set.tiles.startUse();
                }

                int sheetX = set.getTileX(data[sx + tx][sy + ty][1]);
                int sheetY = set.getTileY(data[sx + tx][sy + ty][1]);

                int tileOffsetY = set.tileHeight - mapTileHeight;

                //Call SpriteSheet.renderInUse() to render the sprite cached at slot [sheetX, sheetY]
                set.tiles.renderInUse(x + (tx * mapTileWidth), y
                        + (ty * mapTileHeight) - tileOffsetY, sheetX,
                        sheetY);
            }
        }

        if (lineByLine) {
            if (set != null) {
                set.tiles.endUse();
                set = null;
            }
            map.renderedLine(ty, ty + sy, index);
        }

        if (set != null) {
            set.tiles.endUse();
        }
    }
}