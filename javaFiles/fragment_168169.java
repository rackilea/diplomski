public class TestArc {

    public static void main(String[] args) {
        new TestArc();
    }

    public TestArc() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();

            int radius = Math.min(getWidth(), getHeight());
            int x = (getWidth() - radius) / 2;
            int y = (getHeight() - radius) / 2;

            RadialGradientPaint rgp = new RadialGradientPaint(
                            new Point(getWidth() / 2, getHeight() / 2),
                            radius,
                            new float[]{0f, 1f},
                            new Color[]{Color.RED, Color.YELLOW}
                            );
            g2d.setPaint(rgp);
            g2d.fill(new Arc2D.Float(x, y, radius, radius, 0, 45, Arc2D.PIE));
            g2d.dispose();
        }

    }

}