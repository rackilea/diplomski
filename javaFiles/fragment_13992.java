public void paint(Graphics g) {
    requestFocus(true);
    g.setColor(Color.BLACK);
    g.fillRect(1, 1, 1500 ,950);

    // user panel
    g.setColor(Color.CYAN);
    g.fillRect(playerx, 900, 250, 15);

    //ball
    g.setColor(Color.GREEN);
    g.fillOval(ballx, bally, 30, 30);

    g.dispose();
}