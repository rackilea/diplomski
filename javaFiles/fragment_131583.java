import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NewJFrame extends JFrame {

    private JPanel jp;
    private Timer timer;

    public NewJFrame() {
        initComponents();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationByPlatform(true);
        timer.start();
    }

    public void initComponents() {
        ActionListener al = new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                jp.repaint();
            }
        };
        timer = new Timer(50,al);

        jp = new JPanel() {

            int x;
            int y;
            int xspeed = 1;
            int yspeed = 1;

            Dimension preferredSize = new Dimension(300, 100);

            @Override
            public Dimension getPreferredSize() {
                return preferredSize;
            }

            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                this.move();
                Graphics2D g2 = (Graphics2D)g;
                g2.setRenderingHint(
                        RenderingHints.KEY_ANTIALIASING, 
                        RenderingHints.VALUE_ANTIALIAS_ON);
                g.drawOval(x, y, 20, 20);
            }

            void move() {
                x = x + xspeed;
                y = y + yspeed;
                if (x < 0) {
                    x = 0;
                    xspeed = -xspeed;
                } else if (x > getWidth() - 20) {
                    x = getWidth() - 20;
                    xspeed = -xspeed;
                }

                if (y < 0) {
                    y = 0;
                    yspeed = -yspeed;
                } else if (y == getHeight() - 20) {
                    y = getHeight() - 20;
                    yspeed = -yspeed;
                }
            }
        };
        jp.setBackground(Color.ORANGE);

        this.add(jp);
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }
}