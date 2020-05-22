public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Font font = new Font("Verdana", Font.BOLD, 14);
    g.setFont(font);
    g.setColor(Color.black);
    g.drawString("instructions", 75, 75);
}