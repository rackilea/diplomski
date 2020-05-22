@Override
public void paintComponent(Graphics g) {
    super.paintComponents(g);
    g.setColor(Color.RED);
    g.drawRect(100, 10, 30, 40);
    g.fillRect(x, 10, 20, 10);
    tm.start();
}