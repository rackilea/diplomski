public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();
    if (key == KeyEvent.VK_SPACE)
        if(!Input.jump) {
            velocity += jumpVelocity;
        }
        Input.jump = true;
}

public void keyReleased(KeyEvent e) {
    int key = e.getKeyCode();

    if (key == KeyEvent.VK_SPACE)
        Input.jump = false;
}