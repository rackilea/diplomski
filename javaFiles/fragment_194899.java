void paintTiles(Graphics g)
{
    for (Tile tile : allTiles)
    {
        g.drawImage(tile, player.x, player.y, null);
    }
}