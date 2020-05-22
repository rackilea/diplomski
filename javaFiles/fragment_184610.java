private List<Rectangle> rectangleList = new ArrayList<>();

@Override
protected void paintComponent(Graphics g) {
   super.paintComponent(g);
   Graphics2D g2 = (Graphics2D) g;
   for (Rectangle rectangle : rectangleList) {
      g2.fill(rectangle);
   }
}