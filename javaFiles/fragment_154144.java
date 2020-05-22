trayIcon.addMouseListener(new MouseAdapter() {
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 1) {
            if (Platform.isFxApplicationThread()) {
                Platform.runLater(new Runnable() {
                    @Override public void run() { /* OMITTED FOR BREVITY */ }
                });
            } else {
                Application.launch(Gui.class, "");
            }
        }
    }
});