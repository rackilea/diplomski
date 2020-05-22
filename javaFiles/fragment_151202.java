public void moveRight() {
    if (x < 520) {     // enable moving to the edge of the screen
        x += 10;   // move a little faster
    }
}
public void moveLeft() {
    if (x > 0) {       // enable moving to the edge of the screen
        x -= 10;   // move a little faster
    }
}