switch (colorsCond) {
    case 1:
        g.setColor(Color.RED);
        break;
    case 2:
        g.setColor(Color.BLUE);
        break;
    case 3:
        g.setColor(Color.GREEN);
        break;
}
switch (shapesCond) {
    case 1:
        g.fillRect(x1, y1, rectWidth, rectHeight);
        break;
    case 2:
        g.fillOval(x2, y2, circWidth, circHeight);
        break;
}