int mouseX = e.getX();
int mouseY = e.getY();
Path2D hitShape = null;
for (Path2D shape : shapes) {

    Rectangle bounds = shape.getBounds();
    if (mouseY >= bounds.y && mouseY <= bounds.y + height) {
        int lowerX = bounds.x + bounds.width - 2;
        int upperX = lowerX + 4;
        if (mouseX >= lowerX && mouseX <= upperX) {
            hitShape = shape;
            break;
        }
    }

}

// Deal with the shape you just hit...