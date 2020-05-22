@Override
public void keyPressed(KeyEvent e) {
    int c = e.getKeyCode();
    if (c == KeyEvent.VK_W) {
        player.setYD(-1);

    }
    if (c == KeyEvent.VK_S) {
        player.setXD(-1);
    }
    if (c == KeyEvent.VK_A) {
        player.setYD(1);
    }
    if (c == KeyEvent.VK_D) {
        player.setXD(1);
    }

}