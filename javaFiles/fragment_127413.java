Table chessTable = new Table();
int boardHeight = 8;
int boardWidth = 8;

for (int y = 0; y < boardHeight; y++)
{
    for (int x = 0; x < boardWidth; x++)
    {
        //Check if dividable by two to make checker pattern and add cell to table.
        if (x + y % 2 == 0)
            chessTable.add(blackImage);
        else 
            chessTable.add(whiteImage);
    }
    //Add a new row to table
    chessTable.row();
}