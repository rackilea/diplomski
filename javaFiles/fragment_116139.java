for (int column = 0; column < width; ++column)
{
    for (int row = 0; row < height; ++row)
    {
        if (board[column][row] == 1)
        {
            g.drawOval(column * squareSize + squareSize / 4, row * squareSize + squareSize / 4, squareSize / 2, squareSize / 2);
        }
    }
}