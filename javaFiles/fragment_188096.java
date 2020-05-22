/* REMOVE THIS */
private Rectangle2D.Double shape; // uninitialized!

// constructor
public Brick(int x, int y, int w, int h) {
    super(new Rectangle2D.Double(x, y, w, h));

    //set brick x, y, width, and height
    xPos = x;
    yPos = y;
    width = w;
    height = h;
    // update shape
    // This now references a protected instance variable inherited from the parent.
    shape.setRect((double)xPos, (double)yPos, (double)width, (double)height);
}