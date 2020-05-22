public static void Validate(final int[][] sudokuBoard)
{
    int width = sudokuBoard[0].length;
    int depth = sudokuBoard.length;

    for(int i = 0; i < width; i++)
        if(!IsValidRow(sudokuBoard, i, width))
        {
          //Do something - The row has repetitions
        }
    for(int j = 0; j < height; j++)
        if(!IsValidColumn(sudokuBoard, j, width))
        {
          //Do something - The columns has repetitions
        }
}

static bool IsValidRow(int[][] sudokuBoard, int referenceRow, int width)
{
    //Compare each value in the row to each other
    for(int i = 0; i < width; i++)
    {
        for(int j = i + 1; j < width; j++)
        {
            if(sudokuBoard[referenceRow][i] == sudokuBoard[referenceRow][j])
                return false
        }
    }
    return true;
}

static bool IsValidColumn(int[][] sudokuBoard, int referenceColumn, int height)
{
    //Compare each value in the column to each other
    for(int i = 0; i < height; i++)
    {
        for(int j = i + 1; j < height; j++)
        {
            if(sudokuBoard[i][referenceColumn] == sudokuBoard[j][referenceColumn])
                return false
        }
    }
    return true;
}