static boolean check_KnightMove (int row, int col, int queens[])
{
    if (col >= 3
            && (queens [col - 2] == (row - 1) || queens [col - 2] == (row + 1)))
    {
        return false;
    }

    if (col >= 2
            && (queens [col - 1] == (row - 2) || queens [col - 1] == (row + 2)))
    {
        return false;
    }
    return true;
}