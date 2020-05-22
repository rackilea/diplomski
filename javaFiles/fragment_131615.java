String message = "Application running";

int hoverTime = 1000;
Timer messageTimer = new Timer(hoverTime,
    e -> trayIcon.displayMessage(null, message,
        TrayIcon.MessageType.INFO));
messageTimer.setRepeats(false);

trayIcon.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseEntered(MouseEvent event) {
        messageTimer.restart();
    }

    @Override
    public void mouseExited(MouseEvent event) {
        messageTimer.stop();
    }
});
trayIcon.addMouseMotionListener(new MouseMotionAdapter() {
    @Override
    public void mouseMoved(MouseEvent event) {
        messageTimer.restart();
    }
});