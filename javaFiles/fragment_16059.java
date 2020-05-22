public class SpinningTriangle {

    public static void main(String[] args) {
        new SpinningTriangle();
    }

    public SpinningTriangle() {
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
                frame.add(new FlipPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class FlipPane extends JPanel {

        private Triangle triangle;
        private boolean flip;

        public FlipPane() {
            triangle = new Triangle(50, 100);
            Timer timer = new Timer(500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    flip = !flip;
                    repaint();
                }
            });
            timer.setRepeats(true);
            timer.setCoalesce(true);
            timer.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(110, 110);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            Rectangle bounds = triangle.getBounds();

            double scale = flip ? -1 : 1;

            Path2D path = new Path2D.Float(triangle, AffineTransform.getScaleInstance(scale, scale));
            int x = (getWidth() - bounds.width) / 2;
            int y = (getHeight() - bounds.height) / 2;
            if (flip) {

                y += bounds.height;
                x += bounds.width;

            }
            g2d.translate(x, y);
            g2d.setColor(Color.RED);
            g2d.fill(path);
            g2d.setColor(Color.YELLOW);
            g2d.draw(path);
            g2d.dispose();
        }

    }

    public class Triangle extends Path2D.Float {

        public Triangle(int width, int height) {

            moveTo(width / 2f, 0);
            lineTo(width, height);
            lineTo(0, height);
            closePath();

        }

    }

}