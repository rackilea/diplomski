// you'll need four methods just like this one. This one goes up, you'll need
// one that goes down, another left and a forth right...
static void iterUp(Server[][] grid, int k, int j)
{
    // working with a local variable is easier to read and debug...
    // you may wish to consider it.
    Server cell = grid[k][j]
    if(!cell.isEven() && !cell.isCracked())
    {
        cell.setCracked(true)
        if(k >= 1)
        {
            iterLeft(grid, k-1,j)
        }
        if(k < grid.length - 2)
        {
            iterRight(grid, k+1)
        }
        if(j < grid[k].length - 2)
        {
            iterUp(grid, k, j+1)
        }
        // no point in going down, because we know that down is checked already.
    }
}