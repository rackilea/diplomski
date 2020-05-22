private static final double srqtThree = sqrt(3)/2d;
private Dimension d = new Dimension();
private int rootThree;
public DrawShapes(int sideLength) {
    rootThree = (int) sideLength * sqrt(3)/2d;
}
public void paintComponent(Graphics g){
    getSize(d);
    int y = 0;
    while(y < d.height) {
        // Draw the horizontal line
        g.drawLine(0, y, d.width, y);
        y = y + rootThree;
    }

    // Figure this out mostly yourself, but now you draw the angled sides.
    // Use this to get started. This is the down-to-right line
    g.drawLine(0, 0, d.width / sqrtThree, d.height);
    g.drawLine(sideLength, 0, sideLength + (d.width / sqrtThree), d.height);-

    // Now draw the down-to-left line
}