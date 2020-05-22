int xCounter = 20;
int yCounter = 90;
for (int i = 0; i < 42; i++) {
    // Increment y
    if (x == 540) {
        yCounter += 60;
        xCounter = 0;
    }

    bricks[i] = new GameObject(xCounter, yCounter, BRICK_HEIGHT, BRICK_WIDTH, Colour.BLUE);

    // Increment x
    xCounter += 20;
}