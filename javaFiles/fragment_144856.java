// get the FontMetrics for the current font
FontMetrics fm = g.getFontMetrics();

// find the center location to display
int stringWidth = fm.stringWidth("MyName");
int stringAccent = fm.getAscent();

// get the position of the leftmost character in the baseline
int xCoordinate = getWidth() / 2 - stringWidth / 2;
int yCoordinate = getHeight() / 2 + stringAccent / 2;

g.drawString("MyName", xCoordinate, yCoordinate);