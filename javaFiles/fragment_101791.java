for (int cY = 0; cY < grid.length; cY++)
{
    for (int cX = 0; cX < grid[cY].length; cX++)
    {
        if (this.isWall(cX, cY))
        {
            g.fillRect(cX*Grid.BLOCK_SIZE, cY*Grid.BLOCK_SIZE, Grid.BLOCK_SIZE, Grid.BLOCK_SIZE);
        }
    }
}