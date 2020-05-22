boolean drawingRect = false;

void mousePressed() {
    drawingRect = true;

    color col = color(int(INIT_RED), int(INIT_GREEN), int(INIT_BLUE));
    rectangles.add(new Rectangle(mouseX, mouseY, MIN_SIZE, col));
}

void mouseReleased() {
    drawingRect = false;
}