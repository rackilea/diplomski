@Override
public void mouseEntered(MouseEvent e) {
    ViewCell test = (ViewCell) e.getSource();
    xPos = test.getXPos();
    yPos = test.getYPos();
    // Switch statement and rest of code