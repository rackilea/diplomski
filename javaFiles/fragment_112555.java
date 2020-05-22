import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new Game());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class Game extends JPanel {

        int x, y, xCoord, yCoord;

        public Game() {
            x = 250;
            y = 250;
            addKeyBinding(KeyEvent.VK_LEFT, "move.left", new MoveAction(this, -1, 0));
            addKeyBinding(KeyEvent.VK_RIGHT, "move.right", new MoveAction(this, 1, 0));
            addKeyBinding(KeyEvent.VK_UP, "move.up", new MoveAction(this, 0, -1));
            addKeyBinding(KeyEvent.VK_DOWN, "move.down", new MoveAction(this, 0, 1));
        }

        protected void addKeyBinding(int keyCode, String name, Action action) {
            addKeyBinding(KeyStroke.getKeyStroke(keyCode, 0), name, action);
        }

        protected void addKeyBinding(KeyStroke keyStroke, String name, Action action) {
            InputMap inputMap = getInputMap(WHEN_IN_FOCUSED_WINDOW);
            ActionMap actionMap = getActionMap();
            inputMap.put(keyStroke, name);
            actionMap.put(name, action);
        }

        public void changeCoord() {
            x += xCoord;
            y += yCoord;
            if (x <= 20) {
                x = 20;
            }
            if (x >= 480) {
                x = 480;
            }
            if (y <= 40) {
                y = 40;
            }
            if (y >= 480) {
                y = 480;
            }

            repaint();
        }

        public void setXCoord(int xcoord) {
            xCoord = xcoord;
            changeCoord();
        }

        public void setYCoord(int ycoord) {
            yCoord = ycoord;
            changeCoord();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(480, 480);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.GREEN);
            g.fillOval(x, y, 15, 15);
        }

    }

    public class MoveAction extends AbstractAction {

        private int xDelta;
        private int yDelta;

        // I'd prefer an interface with just the "move" methods, but
        // that's more time I don't have
        private Game game;

        public MoveAction(Game game, int xDelta, int yDelta) {
            this.xDelta = xDelta;
            this.yDelta = yDelta;
            this.game = game;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            game.setXCoord(xDelta);
            game.setYCoord(yDelta);
        }

    }
}