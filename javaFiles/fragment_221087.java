public class TestRotateImage {

    public static void main(String[] args) {
        new TestRotateImage();
    }

    public TestRotateImage() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                }

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JSlider slider;
        private Rectangle rectangle;

        public TestPane() {
            setLayout(new BorderLayout());
            rectangle = new Rectangle(0, 0, 100, 100);
            slider = new JSlider();
            slider.setMinimum(0);
            slider.setMaximum(360);
            slider.setMinorTickSpacing(5);
            slider.setMajorTickSpacing(10);
            slider.setValue(0);
            add(slider, BorderLayout.SOUTH);
            slider.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    repaint();
                }
            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        public double getAngle() {

            return Math.toRadians(slider.getValue());

        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g.create();

            g2d.setColor(Color.RED);
            g2d.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());
            g2d.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);

            g2d.setColor(Color.BLACK);
            int x = (getWidth() - rectangle.width) / 2;
            int y = (getHeight() - rectangle.height) / 2;
            AffineTransform at = new AffineTransform();
            at.setToRotation(getAngle(), x + (rectangle.width / 2), y + (rectangle.height / 2));
            at.translate(x, y);
            g2d.setTransform(at);
            g2d.draw(rectangle);
            g2d.dispose();

        }

    }

}