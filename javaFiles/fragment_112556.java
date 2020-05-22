import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
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

    public enum Direction {
        UP,
        LEFT,
        DOWN,
        RIGHT;
    }

    public class Game extends JPanel {

        int x, y, xCoord, yCoord;

        private Set<Direction> movement;

        public Game() {
            x = 250;
            y = 250;

            movement = new HashSet<>(4);

            addKeyPressedBinding(KeyEvent.VK_LEFT, "left.pressed", new MoveAction(movement, Direction.LEFT, true));
            addKeyReleasedBinding(KeyEvent.VK_LEFT, "left.released", new MoveAction(movement, Direction.LEFT, false));

            addKeyPressedBinding(KeyEvent.VK_RIGHT, "right.pressed", new MoveAction(movement, Direction.RIGHT, true));
            addKeyReleasedBinding(KeyEvent.VK_RIGHT, "right.released", new MoveAction(movement, Direction.RIGHT, false));

            addKeyPressedBinding(KeyEvent.VK_UP, "up.pressed", new MoveAction(movement, Direction.UP, true));
            addKeyReleasedBinding(KeyEvent.VK_UP, "up.released", new MoveAction(movement, Direction.UP, false));

            addKeyPressedBinding(KeyEvent.VK_DOWN, "down.pressed", new MoveAction(movement, Direction.DOWN, true));
            addKeyReleasedBinding(KeyEvent.VK_DOWN, "down.released", new MoveAction(movement, Direction.DOWN, false));

            Timer timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    changeCoord();
                }
            });
            timer.start();
        }

        protected void addKeyBinding(int keyCode, String name, Action action) {
            addKeyBinding(KeyStroke.getKeyStroke(keyCode, 0), name, action);
        }

        protected void addKeyPressedBinding(int keyCode, String name, Action action) {
            addKeyBinding(KeyStroke.getKeyStroke(keyCode, 0, false), name, action);
        }

        protected void addKeyReleasedBinding(int keyCode, String name, Action action) {
            addKeyBinding(KeyStroke.getKeyStroke(keyCode, 0, true), name, action);
        }

        protected void addKeyBinding(KeyStroke keyStroke, String name, Action action) {
            InputMap inputMap = getInputMap(WHEN_IN_FOCUSED_WINDOW);
            ActionMap actionMap = getActionMap();
            inputMap.put(keyStroke, name);
            actionMap.put(name, action);
        }

        public void changeCoord() {

            if (movement.contains(Direction.UP)) {
                y--;
            } else if (movement.contains(Direction.DOWN)) {
                y++;
            }
            if (movement.contains(Direction.LEFT)) {
                x--;
            } else if (movement.contains(Direction.RIGHT)) {
                x++;
            }

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

        private Set<Direction> movement;
        private Direction direction;
        private boolean pressed;

        public MoveAction(Set<Direction> movement, Direction direction, boolean pressed) {
            this.movement = movement;
            this.direction = direction;
            this.pressed = pressed;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (pressed) {
                movement.add(direction);
            } else {
                movement.remove(direction);
            }
        }

    }
}