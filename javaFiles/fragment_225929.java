public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;
    for (Gladiator s : gladiators){
        s.draw(g2);  // note draw should *not* be capitalized!
    }
}