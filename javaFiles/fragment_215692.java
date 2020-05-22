package so;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.util.Random;

import javax.swing.*;

public class TestBall {
    private static void createAndShowUI() {
        final TestPanel panel = new TestPanel();
        panel.validate();
        JFrame frame = new JFrame("TestBall");
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(300, 300));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        ActionListener timerAction = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                panel.moveBall();
            }
        };
        Timer timer = new Timer(1000, timerAction);
        timer.setRepeats(true);
        timer.start();
    }

    static class TestPanel extends JPanel {
        public static int BALL_SIZE = 25;
        private Ellipse2D ball = new Ellipse2D.Double(0, 0, BALL_SIZE,
                BALL_SIZE);
        Random rand = new Random();

        public TestPanel() {
            this.addMouseListener(new MouseAdapter() {
                // Called when the mouse is clicked
                public void mouseClicked(MouseEvent e) {
                    if (ball.contains(e.getPoint())) {
                        System.out.println("hit the ball");
                    }
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.RED);
            g2d.fill(ball);
        }

        public void moveBall() {
            Rectangle ballBounds = ball.getBounds();
            ball.setFrame(ballBounds);
            ballBounds.x = rand.nextInt(getWidth() - BALL_SIZE + 1) + 1;
            ballBounds.y = rand.nextInt(getHeight() - BALL_SIZE + 1) + 1;
            ball.setFrame(ballBounds);
            repaint();
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                createAndShowUI();
            }
        });
    }
}