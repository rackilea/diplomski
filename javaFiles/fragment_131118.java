import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GameTest {

    public static void main(String[] args) {
        new GameTest();
    }

    public GameTest() {
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
                frame.add(new Incoming());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class MyGame extends JPanel implements ActionListener, KeyListener {

        Timer t = new Timer(5, this);
        int x = 0, y = 0, velx = 0, vely = 0, g = 0;

        private Color color;

        public MyGame() {
            color = Color.RED;
            t.start();
            addKeyListener(this);
            setFocusable(true);
            setFocusTraversalKeysEnabled(false);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(color);
            g.fillRect(x, y, 50, 30);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (x < 0) //stops us from going backwards past x = 0
            {
                velx = 0;
                x = 0;
            }

            if (y < 0) //stops us from going to the sky
            {
                vely = 0;
                y = 0;
            }

            if (y > 330) // stops us from going through the ground
            {
                vely = 0;
                y = 330;
            }

            x += velx;
            y += vely;
            repaint();
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int code = e.getKeyCode();

            {
                if (code == KeyEvent.VK_DOWN) {
                    vely = 1; // removing velx = 0 allows us to go vertically and horizontlly at the same time

                }
                if (code == KeyEvent.VK_UP) {
                    vely = -1; // same goes for here

                }
                if (code == KeyEvent.VK_LEFT) {

                    velx = -1;
                }

                {
                    if (code == KeyEvent.VK_RIGHT) {

                        velx = 1;

                    }
                }
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
            velx = 0;
            vely = 0;
        }

    }

    public class Incoming extends MyGame {

        private Color color;

        int x = 0, y = 0, velx = 0, vely = 0;

        public Incoming() {
            color = Color.BLUE;
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(color);
            g.fillRect(x, y, 50, 30);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            super.actionPerformed(e);
            if (x < 0) //stops us from going backwards past x = 0
            {
                velx = 0;
                x = 0;
            }

            if (y < 0) //stops us from going to the sky
            {
                vely = 0;
                y = 0;
            }

            if (y > 330) // stops us from going through the ground
            {
                vely = 0;
                y = 330;
            }

            x += velx;
            y += vely;
            repaint();
        }

        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int code = e.getKeyCode();

            {
                if (code == KeyEvent.VK_NUMPAD2) {
                    vely = 1; // removing velx = 0 allows us to go vertically and horizontlly at the same time

                }
                if (code == KeyEvent.VK_NUMPAD8) {
                    vely = -1; // same goes for here

                }
                if (code == KeyEvent.VK_NUMPAD4) {
                    vely = 0;
                    velx = -1;
                }

                {
                    if (code == KeyEvent.VK_NUMPAD6) {
                        vely = 0;
                        velx = 1;

                    }
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            super.keyReleased(e);
            velx = 0;
            vely = 0;
        }
    }

}