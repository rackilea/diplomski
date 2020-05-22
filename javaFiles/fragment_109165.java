public void run() {
    while(true) {
        update();
        mainPanel.repaint();
        mainPanel.requestFocus(true);
    }
}