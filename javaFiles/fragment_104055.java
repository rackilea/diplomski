private boolean isUnderAttack(int row, int column)
{
    for (int y = 0; y < BOARD_SIZE; y++)
    {
        if (board[row][y] == QUEEN)
            return true; // possible horizontal attack

        int x1 = row - column + y;
        if (0 <= x1 && x1 < BOARD_SIZE && board[x1][y] == QUEEN)
            return true; // diagonal NW

        int x2 = row + column - y;
        if (0 <= x2 && x2 < BOARD_SIZE && board[x2][y] == QUEEN)
            return true; // diagonal SW
    }

    return false;
}