public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;
    for (Gladiator s : gladiators){
        g2.draw(s);
    }
}