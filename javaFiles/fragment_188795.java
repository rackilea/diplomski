private class AL extends KeyAdapter {

    public void keyPressed(KeyEvent event) {

        int keycode = event.getKeyCode();

        if (keycode == KeyEvent.VK_LEFT) {
            x -= 10;
        }
        if (keycode == KeyEvent.VK_RIGHT) {
            x += 10;
        }
        if (keycode == KeyEvent.VK_UP) {
            y -= 10;
        }
        if (keycode == KeyEvent.VK_DOWN) {
            y += 10;
        }
    }

    public void keyReleased(KeyEvent e) {

    }
}