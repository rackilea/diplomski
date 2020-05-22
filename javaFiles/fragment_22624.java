@Override
protected void paintComponent(Graphics g) {
   super.paintComponent(g);
   g.setColor(savedColor);
   g.fillOval(mouseX, mouseY, 15, 15);
}