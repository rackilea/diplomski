// Width and height of rectangular region around mouse
// pointer to use for hit detection on lines
private static final int HIT_BOX_SIZE = 2;



public void mousePressed(MouseEvent e) {
    int x = e.getX();
    int y = e.getY();

    Line2D clickedLine = getClickedLine(x, y);
}


/**
* Returns the first line in the collection of lines that
* is close enough to where the user clicked, or null if
* no such line exists
*
*/

public Line2D getClickedLine(int x, int y) {
int boxX = x - HIT_BOX_SIZE / 2;
int boxY = y - HIT_BOX_SIZE / 2;

int width = HIT_BOX_SIZE;
int height = HIT_BOX_SIZE;

for (Line2D line : getLines()) {
    if (line.intersects(boxX, boxY, width, height) {
        return line;
    }       
}
return null;