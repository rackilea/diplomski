public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();
    if (key == KeyEvent.VK_SPACE)

        if(!Input.jump) {
            isJumping = true;
        } else {
            isJumping = false;
        }
        Input.jump = true;
}