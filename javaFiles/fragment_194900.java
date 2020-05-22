void paintTiles(Graphics g)
{
    int currentPlayerX = player.x;
    int currentPlayerY = player.y;

    for (Tile tile : allTiles)
    {
        g.drawImage(tile, currentPlayerX, currentPlayerY, null);
    }
}