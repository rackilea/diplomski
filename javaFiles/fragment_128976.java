public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
        x-=move;
    }
    else if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
        x+=move;
    }
    this.repaint();
}