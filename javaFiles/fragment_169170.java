@SuppressWarnings("serial")
class MyDrawPanel extends JPanel {
    private static final int PREF_W = 800;
    private static final int PREF_H = 650;
    private static final int OVAL_X = 70;
    private static final int OVAL_W = 100;
    private int red1, green1, blue1, red2, green2, blue2;

    public MyDrawPanel() {
        int w = OVAL_W + 2 * OVAL_X;
        setPreferredSize(new Dimension(w, w));
        randomizeColor();
    }

    public void randomizeColor() {
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
        super.paintComponent(g); // ***** Don't forget this *****
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Color startColor = new Color(red1, green1, blue1);
        Color endColor = new Color(red2, green2, blue2);

        GradientPaint gradient = new GradientPaint(70, 70, startColor, 150, 150, endColor);
        g2d.setPaint(gradient);
        g2d.fillOval(OVAL_X, OVAL_X, OVAL_W, OVAL_W);
    }
}