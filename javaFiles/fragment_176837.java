void setup() {
    size(600, 600);
}

void draw() {

    if (drawingRect && rectangles.size() > 0) {
        Rectangle lastRect = rectangles.get(rectangles.size()-1);
        lastRect.Update(mouseX, mouseY, DIFF_SIZE);
    }

    background(255);

    for (int i = 0; i < rectangles.size(); i++) {
        Rectangle rect = rectangles.get(i);
        rect.Draw();
    }
}