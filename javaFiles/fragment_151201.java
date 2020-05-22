public void moveRight() {
    if (x + 1 < 20) { // can't move very far from the left side of the screen
        x += 1;
    }
}
public void moveLeft() {
    if (x - 1 > -20) { // goes left only a little bit off the screen
        x -= 1;
    }
}