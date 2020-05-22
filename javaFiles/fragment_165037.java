import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.Timer;
import javax.swing.JApplet;
import javax.swing.JPanel;

public class Pong extends JApplet {

    private GamePane gamePane;

    @Override
    public void init() {
        setSize(800, 600);
        gamePane = new GamePane();
        setLayout(new BorderLayout());
        add(gamePane);
    }

    @Override
    public void start() {
        gamePane.start();
    }

    @Override
    public void stop() {
    }

    @Override
    public void destroy() {
    }

    public class GamePane extends JPanel implements MouseMotionListener {

        Ball ball;
        Paddle left_paddle;
        Paddle right_paddle;

        public GamePane() {
            setBackground(Color.WHITE);
            addMouseMotionListener(this);
            setFocusable(true);
            requestFocusInWindow();
        }

        public void start() {
            left_paddle = new Paddle(5, 200);
            right_paddle = new Paddle(this.getWidth() - 30, this.getHeight() / 2);
            ball = new Ball(100, 100, left_paddle, right_paddle);
            Timer timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ball.update(GamePane.this);
                    repaint();
                }
            });
            timer.setRepeats(true);
            timer.setCoalesce(true);
            timer.start();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.

            ball.paint(g);
            left_paddle.paint(g);
            right_paddle.paint(g);
            g.setColor(Color.BLACK);
            g.drawLine(this.getWidth() / 2, 0, this.getWidth() / 2, this.getHeight());

        }

        @Override
        public void mouseDragged(MouseEvent e) {
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            int y = e.getY();
            int x = e.getX();
            if (x < this.getWidth() / 2) { //Control the left paddle
                if (y < 0) {
                    y = 0;
                } else if (y + left_paddle.getHeight() >= this.getHeight()) {
                    y = this.getHeight() - left_paddle.getHeight();
                }
                left_paddle.mouse(y);
            } else {
                if (y < 0) {
                    y = 0;
                } else if (y + right_paddle.getHeight() >= this.getHeight()) {
                    y = this.getHeight() - right_paddle.getHeight();
                }
                right_paddle.mouse(y);
            }
        }
    }

    class Ball {

        private int x;
        private int y;
        private float dx = 4;
        private float dy = 5;
        private int radius = 10;
        private Paddle left, right;

        Ball(int x, int y, Paddle x1, Paddle y1) {
            this.x = x;
            this.y = y;
            left = x1;
            right = y1;
        }

        public void reset() {
            this.x = 400;
            this.y = 200;
        }

        public void update(GamePane ref) {
            if (x + dx < left.getX() + left.getWidth() + radius && y + dy + radius >= left.getY() && y + dy + radius <= left.getY() + left.getHeight()) {
                x = left.getX() + left.getWidth() + radius;
                dx *= (-1);
                // checks the left paddle collision
            } else if (x + dx + radius >= right.getX() && y + dy + radius >= right.getY() && y + dy + radius <= right.getY() + right.getHeight()) {
                x = right.getX() - radius;
                dx *= (-1);
                //checks the right paddle collision
            } //if ball touches the boundary reset it at middle point
            else if (x + dx + radius >= ref.getWidth()) {
                reset();
            } else if (x + dx < radius) {
                reset();
            } else {
                x += dx;
            }

            if (y + dy + radius > ref.getHeight()) {
                y = ref.getHeight() - radius - 1;
                dy *= (-1);
            } else if (y + dy < radius) {
                y = radius;
                dy *= (-1);
            } else {
                y += dy;
            }
        }

        public void paint(Graphics g) {
            g.setColor(Color.RED);
            g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
        }
    }

    public class Paddle {

        private int x;
        private int y;
        private int width = 25;
        private int height = 150;
        private Timer timer;

        public Paddle(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getHeight() {
            return height;
        }

        public int getWidth() {
            return width;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void paint(Graphics g) {
            g.setColor(Color.BLUE);
            g.fillRect(x, y, width, height);
        }

        //mouse lookup
        void mouse(int y_final) {
            y = y_final;
        }
    }
}