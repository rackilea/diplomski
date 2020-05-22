public Tile getTile(int id, int x_pos, int y_pos)
{
    switch (id)
    {
        case 0:  return new GroundTile(x_pos, y_pos); break;
        case 1:  return new SpringTile(x_pos, y_pos); break;
        ...
    }
    return Tile.getEmptyTile(x_pos, y_pos);
}