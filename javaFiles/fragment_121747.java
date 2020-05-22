public void update() {

        if (up == true) {
            SomeMethod(Key.UP);
        }
        if (down == true) {
            SomeMethod(Key.DOWN);
        }
        if (left == true) {
            someMethod(Key.LEFT);
        }
        if (right == true) {
            someMethod(Key.RIGHT);
        }


}
    public void keyReleased(KeyEvent e) {
    switch (e.getKeyCode()) {
    case KeyEvent.VK_S:
        down = false;
        break;
    case KeyEvent.VK_W:
        up = false;
        break;
    case KeyEvent.VK_A:
        left = false;
        break;
    case KeyEvent.VK_D:
        right = false;
        break;
    }
}

public void keyPressed(KeyEvent e) {
    switch (e.getKeyCode()) {
    case KeyEvent.VK_S:
        down = true;
        break;
    case KeyEvent.VK_W:
        up = true;
        break;
    case KeyEvent.VK_A:
        left = true;
        break;
    case KeyEvent.VK_D:
        right = true;
        break;