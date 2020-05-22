public void paint(Graphics g) {
    super.paint(g); //this paints all of your JPanel's child components, including your JPanel

    Graphics2D g2d = (Graphics2D) g;

//      g2d.drawImage(background, 0, 0, this); // this is painting your background image over your JPanel.

    player.draw(g2d);

    ...