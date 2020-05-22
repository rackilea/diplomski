public Board(int size)
{
    setBoard(size);
    board = new char[size][size]; // initializes the board field
    for (int row = 0; row < size; row++) {
         for (int col = 0; col < size; col++) {
             board[row][col] = 'E';
         }
    }
}