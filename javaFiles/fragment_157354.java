public class SimplePaint02 {

    public static void main(String[] args) {
        new SimplePaint02();
    }

    public SimplePaint02() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame();
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

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(100, 100);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int radius = Math.min(getWidth(), getHeight());
            int x = (getWidth() - radius) / 2;
            int y = (getHeight()- radius) / 2;

            BufferedImage buffer = new BufferedImage(radius, radius, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = buffer.createGraphics();

            Ellipse2D circle = new Ellipse2D.Float(0, 0, radius, radius);
            Shape clip = g2d.getClip();
            g2d.setClip(circle);
            int gap = getWidth() / 10;
            g2d.setColor(Color.RED);
            for (int index = 0; index < 10; index++) {

                g2d.drawLine(index * gap, 0, index * gap, radius);

            }
            g2d.setClip(clip);
            g2d.setColor(Color.BLUE);
            g2d.draw(circle);
            g2d.dispose();
            g.drawImage(buffer, x, y, this);
        }

    }

}