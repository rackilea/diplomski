private class KeyInputHandler extends KeyAdapter {

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            dx = -1;
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            dx = 1;
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            dy = -1;
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            dy = 1;
        }

        //first call move to update x and y and later repaint tha JPanel
        move();
        repaint();
    }
}