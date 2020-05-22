for(int i=0; i < row; i++)
{
    for(int j=0; j < column; j++)
    {
        cell = cur.getCell(i, j);
        cur.setCell(i * 8, j * 8, cell);
        cell.setTile(new StaticTiledMapTile("Some type of TextureRegion/Texture");
    }
}