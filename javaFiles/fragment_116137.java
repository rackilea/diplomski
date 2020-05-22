@Override
public void paintComponent(Graphics g)
{
    super.paintComponent(g);

    // Draw the board
    for (int i = 0; i < height; i++)
    {
        for (int j = 0; j < width; j++)
        {
            g.drawRect(j * squareSize, i * squareSize, squareSize, squareSize);
        }
    }

    // Draw the ellipse at the correct location using half the size of a normal square.
    g.drawOval(elX * squareSize + squareSize / 4, elY * squareSize + squareSize / 4, squareSize / 2 , squareSize / 2);
}