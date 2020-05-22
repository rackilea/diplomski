public TileType[][] getMap() {
    TileType[][] map = new TileType[GameWidth][Gameheight];

    for (int x = 0; x < GameWidth; x++) {
        for (int y = 0; y < Gameheight; y++) {
            map[x][y] = TileType.Nothing;
        }
    }

    for (Coordinate wall: walls) {
        map[wall.getX()][wall.getY()] = TileType.Wall;
    }

    return map;


 }