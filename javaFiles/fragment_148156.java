static void getLinksEven(Server[][] grid, int k, int j)
{
    if(grid.length < k - 1 || grid[k].length < j - 1)
    {
        throw new ArrayIndexOutOfBoundsException("Not funny.");
    }
    // if this cell isn't even... who cares?
    if(!grid[k][j].isEven()) return;

    // Send the four on their merry way.
    iterUp(grid,k,j);
    iterDown(grid,k,j);
    iterLeft(grid,k,j);
    iterRight(grid,k,j);
}