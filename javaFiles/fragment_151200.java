public void moveRight() {
    if (dx + 1 < 20) {
        dx += 1; // updating dx, but x is used to paint
    }
}
public void moveLeft() {
    if (dx - 1 > -20) {
        dx -= 1; // updating dx, but x is used to paint
    }
}