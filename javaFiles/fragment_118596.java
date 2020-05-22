public void paintTheMaze(graphics g) {
    final int tileWidth = 32;
    final int tileHeight = 32;
    g.setColor(Color.BLACK);

    for (int x = 0; x < maze.width(); ++x) {
        for (int y = 0;  y < maze.height(); ++y) {
            if (maze.get(x, y).equals(Tile.Blocked)) (
                 g.fillRect(x*tileWidth, y*tileHeight, tileWidth, tileHeight);
            }
        }
    )

}