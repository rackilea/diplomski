public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
        out.println("Left key pressed");
        currentDir = "left";
        moveTimer.start();
    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
        out.println("Right key pressed");
        currentDir = "right";
        moveTimer.start();
    } else if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
        out.println("Up key pressed");
        currentDir = "up";
        moveTimer.start();
    } else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
        out.println("Down key pressed");
        currentDir = "down";
        moveTimer.start();
    }
}