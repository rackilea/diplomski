@Override
protected void paintComponent(Graphics g) {
   super.paintComponent(g);
   Graphics2D g2 = (Graphics2D) g;
   g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
   g2.clearRect(0, 0, this.getWidth(), this.getHeight());
   crtanjeMatrice(g2);
   for (MyRowColumn index : indexList) { // MyRowColumn based on Point
     g2.setColor(Color.blue);
     g2.fill(matrica[index.x][index.y]);
   }
}