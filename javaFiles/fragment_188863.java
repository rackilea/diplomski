public class Circle extends JPanel {

    int number = 10;
    float size = 500f;
    float rad = 70f;
    float stringLocX = 15f, stringLocy = 20f;

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));

        g2d.setColor(Color.BLACK);
        g2d.draw(new Line2D.Double(0f, 0f, size, size));
        g2d.draw(new Line2D.Double(0f, size, size, 0f));
        g2d.draw(new Line2D.Double(0f, size / 2, size, size / 2));
        g2d.draw(new Line2D.Double(size / 2, 0f, size / 2, size));
        g2d.draw(new Line2D.Double(150f, 0f, 350f, 500f));

        Ellipse2D.Float circle = new Ellipse2D.Float((size - rad) / 2, (size - rad) / 2, rad, rad);
        g2d.setColor(Color.WHITE);
        g2d.fill(circle);
        g2d.setColor(Color.BLACK);
        g2d.draw(circle);
        g2d.drawString(Integer.toString(number), (size - rad) / 2 + stringLocX,
                        (size - rad) / 2 + stringLocy);
    }

    @Override
    public Dimension getPreferredSize() {

        return new Dimension((int) size, (int) size);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.add(new Circle());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        });
    }
}