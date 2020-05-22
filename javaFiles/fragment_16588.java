for(int x = 0; x < SCREEN_WIDTH / GameTile.tileSize; x++) { // loop through as many tiles fit the x-axis.
    for(int y = 0; y < SCREEN_HEIGHT / GameTile.tileSize; y++) { // do the same with y-axis
        GameTile greenTile = new GameTile(0,true, x * GameTile.tileSize , y * GameTile.tileSize);
        gameWindow.add(greenTile);
     }
}