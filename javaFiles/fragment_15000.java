GameFrame gf;

public GamePanel(GameFrame gf) {
    this.gf = gf;
    // Pointless as the layout manager will take care of it
    //this.setSize(500, 500);
    // Pointless as Swing components are visible by default
    //this.setVisible(true);
    this.setFocusable(true);
}

@Overrride
protected void paintComponent(Graphics comp) {
    super.paintComponent(comp);
    int wrongGuess = gf.wrongGuess;

    if (wrongGuess == 5) {
        comp.drawOval(162, 150, 50, 50);
        comp.drawLine(188, 200, 188, 275);
        comp.drawLine(148, 235, 188, 215);
        comp.drawLine(188, 215, 228, 235);
        comp.drawLine(188, 275, 228, 335);
        comp.drawLine(148, 335, 188, 275);
    }
    // Don't do this here, this will cause no end of issues
    //repaint();
}