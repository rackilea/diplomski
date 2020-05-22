@Override
public void actionPerformed(ActionEvent e) 
{
    // Set the new x and y coordinates, depending on which direction we have moved
    xPos += movementX;
    yPos += movementY;

    if (xPos < 0) {
        xPos = 0;
    } else if (xPos + squareSize > xBound) {
        xPos = xBound - squareSize;
    }
    if (yPos < 0) {
        yPos = 0;
    } else if (yPos + squareSize > yBound) {
        yPos = yBound - squareSize;
    }

    // Redraw the square when something happens
    repaint();
}