public void paintComponent(Graphics g) {
    super.paintComponent(g); // erase back
    Graphics2D g2 = (Graphics2D) g;
    for (Ball b : balls) {
        g2.setColor(color);
        g2.fill(b.getShape());
    }
}

private ArrayList<Ball> balls = new ArrayList<Ball>();

private Color color = Color.RED;

public Color getColor() {
    return color;
}

public void setColor(Color color) {
    this.color = color;
}

public ArrayList<Ball> getBalls() {
    return balls;
}