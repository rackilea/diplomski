static final int ROW_END = 4;
static final int COLUMN_END = 11;

// ...

// traverse maze recursively
public boolean mazeTraversal(int row, int column)
{
    maze[row][column] = 'x';
    printMaze();

    if (column == COLUMN_END && row == ROW_END)
    {
        return true;
    }

    if (column > 0 && maze[row][column - 1] == '.')
    {
        maze[row][column - 1] = 'x';
        return mazeTraversal(row, column - 1);
    }

    if (column < 11 && maze[row][column + 1] == '.')
    {
        maze[row][column + 1] = 'x';
        return mazeTraversal(row, column + 1);
    }

    if (row > 0 && maze[row - 1][column] == '.')
    {
        maze[row - 1][column] = 'x';
        return mazeTraversal(row - 1, column);
    }

    if (row < 11 && maze[row + 1][column] == '.')
    {
        maze[row + 1][column] = 'x';
        return mazeTraversal(row + 1, column);
    }

    maze[row][column] = 'o';

    if (column < 11 && maze[row][column + 1] == 'x')
    {
        maze[row][column + 1] = 'o';
        return mazeTraversal(row, column + 1);
    }

    if (column > 0 && maze[row][column - 1] == 'x')
    {
        maze[row][column - 1] = 'o';
        return mazeTraversal(row, column - 1);
    }

    if (row < 11 && maze[row + 1][column] == 'x')
    {
        maze[row + 1][column] = 'o';
        return mazeTraversal(row + 1, column);
    }

    if (row > 0 && maze[row - 1][column] == 'x')
    {
        maze[row - 1][column] = 'o';
        return mazeTraversal(row - 1, column);
    }

    return true;
} // end method mazeTraversal