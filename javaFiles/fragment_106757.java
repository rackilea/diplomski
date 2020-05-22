boolean checkWest(int indexA, int indexB)
{
    if (indexA > 0) 
        return grid[indexA - 1][indexB] == 1;
    else
        return grid[width + indexA - 2][indexB] == 1;
}