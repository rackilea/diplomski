public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();
    if (key == KeyEvent.VK_UP) {
        bill.orientation = 0;
        bill.y -= 10;
        repaint();
    }
}