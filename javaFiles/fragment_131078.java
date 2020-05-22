int mouseX = e.getX();
int mouseY = e.getY();
Path2D hitShape = null;
for (Path2D shape : shapes) {

    Rectangle bounds = shape.getBounds();
    // Upper edge...with buffer...
    if (mouseY >= bounds.y - 4 && mouseY <= bounds.y + 4) {
        int lowerX = bounds.x + bounds.width - 2;
        int upperX = lowerX + 4;
        // Right corner....
        if (mouseX >= lowerX && mouseX <= upperX) {
            hitShape = shape;
            break;
        }
    }

}