import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Player {

    int x = 70;
    int y = 70;

    private Timer timer;
    Window win = new Window();

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                Player p = new Player();
                p.go();
            }
        });
    }

    public void go() {
        JFrame f = new JFrame("title");
        f.add(BorderLayout.CENTER, win);
        JButton b = new JButton("Start");
        f.add(BorderLayout.SOUTH, b);
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        timer = new Timer(40, new ActionListener() {
            private int counter = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (counter < 130) {
                    counter++;
                    win.updateLocation();
                    win.repaint();
                } else {
                    timer.stop();
                    counter = 0;
                }
            }
        });

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!timer.isRunning()) {
                    timer.start();
                }
            }
        });
    }

    class Window extends JPanel {

        private int x = 70;
        private int y = 70;

        public void updateLocation() {
            x++;
            y++;
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(170+130, 170+130);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.fillOval(x, y, 100, 100);
        }

    }
}