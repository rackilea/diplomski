void draw() {

    background(0);

    if (keyPressed && keyCode == UP) {
        image(bg3, 0, 0);
    } else {
        image(bg1, 0, 0);
    }
}