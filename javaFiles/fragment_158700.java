public void paintComponent(final Graphics g) {
 super.paintComponent(g);

 g.setColor(Color.black);
 g.drawOval(x,y,width,height);
 g.fillOval(x,y,width,height);
}