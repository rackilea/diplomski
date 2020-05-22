public class TestAnimationSpeed {

    public static void main(String[] args) {
        new TestAnimationSpeed();
    }

    public TestAnimationSpeed() {
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
                frame.add(new AnimationPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class AnimationPane extends JPanel {

        private JSlider slider;
        private BouncyPane bouncyPane;

        public AnimationPane() {
            setLayout(new BorderLayout());
            bouncyPane = new BouncyPane();
            add(bouncyPane, BorderLayout.CENTER);
            slider = new JSlider(1, 11);
            slider.setMajorTickSpacing(2);
            slider.setPaintTicks(true);
            add(slider, BorderLayout.SOUTH);
            slider.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    bouncyPane.setVerticalSpeed(slider.getValue());
                }
            });
            slider.setValue(4);
        }

    }

    public class BouncyPane extends JPanel {

        private int dy = 4;
        private Ellipse2D ball;

        public BouncyPane() {
            ball = new Ellipse2D.Float(100, 0, 10, 10);
            Timer timer = new Timer(1000/60, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    double y = ball.getY();
                    y += dy;
                    if (y + ball.getHeight() > getHeight()) {
                        y = getHeight() - ball.getHeight();
                        dy *= -1;
                    } else if (y < 0) {
                        y = 0;
                        dy *= -1;
                    }
                    ball.setFrame(ball.getX(), y, ball.getWidth(), ball.getHeight());
                    repaint();
                }
            });
            timer.setRepeats(true);
            timer.setCoalesce(true);
            timer.start();
        }

        public void setVerticalSpeed(int speed) {
            if (dy < 0 && speed > 0) {
                dy = -speed;
            } else {
                dy = speed;
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(Color.RED);
            g2d.fill(ball);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

}