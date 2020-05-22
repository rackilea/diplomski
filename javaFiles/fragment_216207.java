public void keyPressed(KeyEvent event) {
    if (event.getKeyCode() == theKeyICareAbout) {
        synchronized (keyPressMonitor) {
            running = true;
            keyPressMonitor.notifyAll();
        }
    }
}

public void keyReleased(KeyEvent event) {
    if (event.getKeyCode() == theKeyICareAbout) {
        synchronized (keyPressMonitor) {
            running = false;
            keyPressMonitor.notifyAll();
        }
    }
}