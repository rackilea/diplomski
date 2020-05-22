import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Move {

    public static void main(String[] args) {
        new Move();
    }

    public Move() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new Main());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public static class Main extends JPanel {

        public static int place = -350;
        public Rectangle rect;
        public int xDelta;

        public Main() {

            rect = new Rectangle(0, 75, 50, 50);
            xDelta = 4;
            Timer timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    rect.x += xDelta;
                    if (rect.x + rect.width > getWidth() - 1) {
                        rect.x = getWidth() - rect.width;
                        xDelta *= -1;
                    } else if (rect.x < 0) {
                        rect.x = 0;
                        xDelta *= -1;
                    }
                    repaint();
                }
            });
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
            Random r = new Random();
            int r1;

            r1 = r.nextInt(5);
            if (r1 == 0) {
                g2d.setColor(Color.WHITE);
            } else if (r1 == 1) {
                g2d.setColor(Color.BLUE);
            } else if (r1 == 2) {
                g2d.setColor(Color.RED);
            } else if (r1 == 3) {
                g2d.setColor(Color.GREEN);
            } else if (r1 == 4) {
                g2d.setColor(Color.PINK);
            } else {
                g2d.setColor(Color.CYAN);
            }

//            place += 50;

//            rect = new Rectangle(place, 100, 300, 200);
            g2d.draw(rect);
            g2d.fill(rect);
            g2d.dispose();

        }
    }
}