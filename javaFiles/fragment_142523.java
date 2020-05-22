public void moveBall() {
    x += dx;
    y += dy;

    // Check Boundaries
    if (x < radius || x > getWidth() - radius) {
        dx *= -1; //change Ball direction
    }
    if (y < radius || y > getHeight() - radius) {
        dy *= -1; //change Ball direction
    }

    circle.setCenterX(x);
    circle.setCenterY(y);
}