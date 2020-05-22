import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ControlBall extends JFrame {

    private JButton jbtRed = new JButton("Red");
    private JButton jbtGreen = new JButton("Green");
    private JButton jbtBlue = new JButton("Blue");
    private JButton jbtBlack = new JButton("Black");
    private BallCanvas canvas = new BallCanvas();
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menu = new JMenu("Edit");
    private JMenuItem miEnlarge = new JMenuItem("Enlarge");
    private JMenuItem miShrink = new JMenuItem("Shrink");

    public ControlBall() {

        menuBar.add(menu);
        menu.add(miEnlarge);
        menu.add(miShrink);

        JPanel panel = new JPanel();
        panel.add(jbtRed);
        panel.add(jbtGreen);
        panel.add(jbtBlue);
        panel.add(jbtBlack);

        this.add(canvas, BorderLayout.CENTER);
        this.add(panel, BorderLayout.SOUTH);
        this.add(menuBar, BorderLayout.NORTH);

        jbtRed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.setColor(Color.RED);
            }
        });

        jbtGreen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.setColor(Color.GREEN);
            }
        });

        jbtBlue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.setColor(Color.BLUE);
            }
        });

        jbtBlack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.setColor(Color.BLACK);
            }
        });

        miEnlarge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.enlarge();
            }
        });

        miShrink.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.shrink();
            }
        });

        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                canvas.changeSize(e);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                canvas.move(e);
            }
        });
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new ControlBall();
                frame.setTitle("ControlBall");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });

    }

    public static class BallCanvas extends JPanel {

        private static final int SIZE = 400;
        private int radius = 20;
        private Color color = Color.BLACK;
        private int ballX = SIZE / 2 - radius;
        private int ballY = SIZE / 2 - radius;

        public BallCanvas() {
            System.out.println(getWidth() + " " + getHeight());
        }

        public BallCanvas(int initialRadius) {
            radius = initialRadius;
        }

        public void setColor(Color color) {
            this.color = color;
            repaint();
        }

        public void changeSize(MouseEvent e) {

            int numClicks = e.getClickCount();

            if (e.isAltDown()) {
                if (radius >= 6) {
                    this.radius -= 5 * numClicks;
                } else {
                    // do nothing
                }
            } else {

                this.radius += 5 * numClicks;
            }

            repaint();

        }

        public void enlarge() {

            this.radius += 5;
            repaint();

        }

        public void shrink() {

            if (radius >= 10) {
                this.radius -= 5;
            }
            repaint();
        }

        public void move(MouseEvent e) {

            ballX = e.getX() - radius;
            ballY = e.getY() - radius;
            repaint();

        }

        @Override
        protected void paintComponent(Graphics g) {

            super.paintComponent(g);
            g.setColor(color);
            g.fillOval(ballX, ballY, 2 * radius, 2 * radius);

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(SIZE, SIZE);
        }
    }
}