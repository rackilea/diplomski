public void keyTyped(KeyEvent evt) {
    if (evt.getKeyChar() == ' ') {
           Thread th = new Thread(movingBoxInstance);
           th.start();
    }
}