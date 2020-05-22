import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GameExample {

    public static void main(String[] args) {
        new GameExample();
    }

    public GameExample() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                MyGame game = new MyGame();

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(game);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class MyGame extends JPanel implements ActionListener {

        Timer t = new Timer(5, this);
        int x = 0, y = 0, velx = 0, vely = 0, g = 0;

        public MyGame() {
            t.start();
            setFocusTraversalKeysEnabled(false);
            setForeground(Color.RED);

            InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "up-pressed");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false), "down-pressed");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "left-pressed");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "right-pressed");

            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, true), "up-released");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true), "down-released");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true), "left-released");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), "right-released");

            ActionMap am = getActionMap();
            am.put("up-pressed", new YDelatAction(-1));
            am.put("down-pressed", new YDelatAction(1));
            am.put("left-pressed", new XDelatAction(-1));
            am.put("right-pressed", new XDelatAction(1));

            am.put("up-released", new YDelatAction(0));
            am.put("down-released", new YDelatAction(0));
            am.put("left-released", new XDelatAction(0));
            am.put("right-released", new XDelatAction(0));
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(getForeground());
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

        public class XDelatAction extends AbstractAction {

            private int value;

            public XDelatAction(int value) {
                this.value = value;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                vely = 0;
                velx = value;
            }

        }

        public class YDelatAction extends AbstractAction {

            private int value;

            public YDelatAction(int value) {
                this.value = value;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                vely = value;
            }

        }

    }

}