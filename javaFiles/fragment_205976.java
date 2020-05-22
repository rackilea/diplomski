public void paint(Graphics screen) {
    super.paint(screen);
    Graphics2D G2D = (Graphics2D) screen;
    G2D.drawImage(hud_right, 570, 0, null);
    G2D.drawImage(hud_bottom, 0, 410, null);
}