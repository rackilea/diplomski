private void drawTree(double x, double y, int depth, int maxDepth, Graphics graphics, double sideLength) {
    if (depth >= maxDepth) {
        return;
    }

    double leftX = x - sideLength / 2;
    double leftY = y + Math.sqrt(sideLength * 3) / 2;
    double rightX = x + sideLength / 2;
    double rightY = leftY;

    //draw line from (x,y) -> (leftX, leftY)
    graphics.drawLine(x, y, leftX, leftY);
    //draw line from (x,y) -> (rightX, rightY)
    graphics.drawLine(x, y, rightX, rightY);
    //draw line from (leftX, leftY) -> (rightX, rightY)
    graphics.drawLine(leftX, leftX, rightX, rightY);

    drawTree(leftX, leftY, depth + 1, maxDepth, graphics, sideLength);
    drawTree(rightX, rightY, depth + 1, maxDepth, graphics, sideLength);
}