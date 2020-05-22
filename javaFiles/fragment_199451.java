private java.util.List<Shape> shapesToFill = new ArrayList<>();

public Panel(java.util.List<Shape> shapes) {
    this.shapesToFill.addAll(shapes);
    //...
}

@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    shapesToFill.forEach(g2d::fill);
}