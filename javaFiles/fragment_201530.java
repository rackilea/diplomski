Image[][] displayedMap = new Image[MAP[0].length][MAP.length];
public Town() {
    System.out.println("Map len" + MAP.length);
    for (int x = 0; x < MAP.length; x++) {
        for (int y = 0; y < MAP[0].length; y++) {
            System.out.println("X:" + x + ",Y:" + y);
            setImageContent(x, y);
        }
    }
}

private void setImageContent(int x, int y) {
    Terrain t = Terrain.getTerrainFor(MAP[x][y]);
    displayedMap[x][y] = t.getImage();
}