int chutCount = 0;
while (chutCount < Chut)
{
    int randomNum = ran.nextInt(board.length);
    if (board[randomNum].addSpaces == 0) // uninitialized
    {
        board[randomNum] = new Cell(-10);
        chutCount++;
    }
}