public class Test {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(600, 200);
        final BufferedImage image = new BufferedImage(600, 200, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = image.createGraphics();
        paintExampleBubble(graphics, 250, 50, foreground);
        graphics.dispose();
        final JPanel panel = new JPanel() {

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D)g;

                final BufferedImage i2 = new BufferedImage(600, 200, BufferedImage.TYPE_INT_ARGB);
                Graphics2D graphics = i2.createGraphics();
                paintExampleBubble(graphics, 50, 50, alphaForeground);
                graphics.dispose();
                g.drawImage(i2, 0, 0, this);
                //use Alpha Composite for transparency
                Composite comp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER , alpha );
                g2d.setComposite(comp);
                g2d.drawImage(image, 0, 0, this);

                paintExampleBubble(g2d, 450, 50, foreground);
            }
        };
        javax.swing.Timer timer = new javax.swing.Timer(100, new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                alpha -= 0.05;

                if ( alpha < 0 ){
                    alpha = 1.0f;
                }
                alphaForeground = new Color(0f, 0f, 0f, alpha);
                panel.repaint();
            }

        });
        timer.start();
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    private static float alpha = 1.0f;
    private static final Color background = new Color(1f, 1f, 1f, 1f);
    private static final Color foreground = new Color(0f, 0f, 0f, 1f);
    private static Color alphaForeground = new Color(0f, 0f, 0f, alpha);
    private static final int borderRadius = 16;
    private static final int width = 100;
    private static final int height = 50;

    private static void paintExampleBubble(Graphics g, int x, int y, Color color) {
        g.setColor(background);
        g.fillRoundRect(x, y, width, height, borderRadius, borderRadius);
        g.setColor(color);
        g.drawRoundRect(x, y, width, height, borderRadius, borderRadius);
    }
}