public class SimplePaint01 {

    public static void main(String[] args) {
        new SimplePaint01();
    }

    public SimplePaint01() {
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
                frame.setContentPane(new PaintPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class PaintPane extends JPanel {

        private int angle = 0;
        private Rectangle shape = new Rectangle(0, 0, 100, 100);

        public PaintPane() {
            setBackground(Color.RED);
            Timer timer = new Timer(16, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    angle += 5;
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
            Graphics2D g2d = (Graphics2D) g.create();

            int x = ((getWidth() - shape.width) / 2);
            int y = ((getHeight() - shape.height) / 2);

            shape.x = x;
            shape.y = y;

            g2d.setColor(Color.BLUE);
            g2d.setTransform(AffineTransform.getRotateInstance(Math.toRadians(angle), x + (shape.width / 2), y + (shape.height / 2)));
            g2d.fill(shape);

            g2d.dispose();
        }

    }

}