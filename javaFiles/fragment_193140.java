public void paint(Graphics g) {
    if (mainMenu) {
        g.setColor(Color.CYAN); // Set main menu
        g.fillRect(0, 0, winWidth, winHeight);
        g.setColor(Color.GREEN);
        g.fillRect(buttonOneX, buttonOneY, buttonOneW, buttonOneH);
    }
    if (buttonOne) {
        mainMenu = false;
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, winWidth, winHeight);
    }
}