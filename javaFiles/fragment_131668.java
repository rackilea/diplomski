public class TestRotation {

    public static void main(String[] args) {
        new TestRotation();
    }

    public TestRotation() {
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
                frame.add(new AnimationPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

        });
    }

    public class AnimationPane extends JPanel {

        private List<BufferedImage> images;
        private List<Double> angles;
        private List<Double> speed;

        public AnimationPane() {
            images = new ArrayList<>(5);
            images.add(createWheel(50, 4));
            images.add(createWheel(50, 3));
            images.add(createWheel(50, 6));
            angles = new ArrayList<>();
            speed = new ArrayList<>();
            for (int index = 0; index < images.size(); index++) {
                angles.add(0d);
                speed.add(Math.random() * 5d);
            }

            Timer timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (int index = 0; index < angles.size(); index++) {
                        double angle = angles.get(index);
                        double delta = speed.get(index);
                        angle += delta;
                        angles.set(index, angle);
                    }
                    repaint();
                }
            });
            timer.setRepeats(true);
            timer.setCoalesce(true);
            timer.start();

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int x = 0;
            int y = 0;
            for (int index = 0; index < images.size(); index++) {
                BufferedImage image = images.get(index);
                double angle = angles.get(index);

                // This is important.  Basically we going to grab a isolated snap shot
                // of the current graphics context.  This means any changes we make
                // will not affect the original graphics context (other then painting)
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                AffineTransform at = new AffineTransform();
                at.translate(x, y);
                at.rotate(Math.toRadians(angle), image.getWidth() / 2, image.getHeight() / 2);
                g2d.setTransform(at);
                g2d.drawImage(image, 0, 0, this);
                g2d.dispose();

                x += image.getWidth();

            }
        }

    }

    protected Point2D calculateOutterPoint(int radius, double angel) {

        int x = Math.round(radius / 2);
        int y = Math.round(radius / 2);

        double rads = Math.toRadians((angel + 90));

        // This determins the length of tick as calculate from the center of
        // the circle.  The original code from which this derived allowed
        // for a varible length line from the center of the cirlce, we
        // actually want the opposite, so we calculate the outter limit first
        double fullLength = (radius / 2d);

        // Calculate the outter point of the line
        double xPosy = (x + Math.cos(rads) * fullLength);
        double yPosy = (y - Math.sin(rads) * fullLength);

        return new Point2D.Double(xPosy, yPosy);

    }

    public BufferedImage createWheel(int radius, int spokes) {
        BufferedImage img = new BufferedImage(radius, radius, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.black);
        g2d.drawOval(0, 0, radius - 1, radius - 1);

        Point2D center = new Point2D.Double(radius / 2d, radius / 2d);
        double angle = 360d / spokes;
        for (int index = 0; index < spokes; index++) {
            Point2D p = calculateOutterPoint(radius, index * angle);
            g2d.draw(new Line2D.Double(center, p));
        }

        g2d.dispose();
        return img;

    }

}