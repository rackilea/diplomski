public Board(int size)
{
    setBoard(size);
    board = new char[size][size]; // initializes the board field
    for (char[] row : board) {
        Arrays.fill(row, 'E');
    }
}