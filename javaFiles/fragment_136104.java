import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class AnimatedBall2 {

    public static void main(String[] args) {
        new AnimatedBall2();
    }

    public AnimatedBall2() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                final MyDrawPanel panel = new MyDrawPanel();

                JFrame frame = new JFrame("I'm a banana");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(panel);
                frame.pack();
                frame.setVisible(true);

                Timer timer = new Timer(50, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        panel.update();
                    }
                });
                timer.start();

            }
        });
    }

    public class MyDrawPanel extends JPanel {

        int x;
        int y;

        int deltaX = 0;
        int deltaY = 1;

        public MyDrawPanel() {
            x = 150;
            y = 150;
            setBackground(Color.WHITE);
        }

        public void update() {
            x += deltaX;
            y += deltaY;
            if (x < 0) {
                x = 0;
                deltaX *= 1;
            } else if (x > getWidth()) {
                x = getWidth();
                deltaX *= 1;
            }
            if (y < 0) {
                y = 0;
                deltaY *= -1;
            } else if (y > getHeight()) {
                y = getHeight();
                deltaY *= -1;
            }
            repaint();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(300, 300);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.orange);
            g.fillOval(x - 50, y - 50, 100, 100);

        }
    }
}