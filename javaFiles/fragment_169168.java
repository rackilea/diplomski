private int red1, green1, blue1, red2, green2, blue2;

@Override
public void actionPerfomed(ActionEvent e) {
    red1 = (int) (Math.random() * 256);
    green1 = (int) (Math.random() * 256);
    blue1 = (int) (Math.random() * 256);

    red2 = (int) (Math.random() * 256);
    green2 = (int) (Math.random() * 256);
    blue2 = (int) (Math.random() * 256);
    repaint();
}

@Override
public void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;

    Color startColor = new Color(red1, green1, blue1);
    Color endColor = new Color(red2, green2, blue2);

    GradientPaint gradient = new GradientPaint(70,70,startColor, 150,150, endColor);
    g2d.setPaint(gradient);
    g2d.fillOval(70,70,100,100);
}