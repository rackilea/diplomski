import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Game extends JFrame {

    public GamePanel panel;

    public Game() {
        addComponentListener(new ComponentAdapter() {
            private boolean initalised = false;
            private Timer timer = new Timer(250, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    initalised = true;
                    panel.init();
                    timer.stop();
                }
            });

            @Override
            public void componentResized(ComponentEvent e) {
                if (!initalised) {
                    timer.restart();
                }
            }
        });
        setTitle("Game");
        setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new GamePanel(this);
        add(panel);
        setResizable(false);
        pack();
        setVisible(true);
    }

    public GamePanel getPanel() {
        return panel;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                new Game();
            }
        });
    }

    public static class GamePanel extends JPanel implements ActionListener, KeyListener {

        public final static int WIDTH = 700, HEIGHT = 450;

        public Game game;
        public Player player;

        public GamePanel(Game game) {
            setBackground(Color.GREEN);
            this.game = game;
            addKeyListener(this);
            setFocusable(true);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(WIDTH, HEIGHT);
        }

        public void init() {
            System.out.println("!!");
            player = new Player(this, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, getWidth() - 50);
            repaint();
        }

        public void update() {
            player.update();
        }

        public void actionPerformed(ActionEvent e) {
            update();
            repaint();
        }

        public Player getPlayer(int playerNo) {
            return player;
        }

        public void keyPressed(KeyEvent e) {
            player.pressed(e.getKeyCode());
        }

        public void keyReleased(KeyEvent e) {
            player.released(e.getKeyCode());
        }

        public void keyTyped(KeyEvent e) {
            ;
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (player != null) {
                player.paint(g);
            }
        }
    }

    public static class Player {

        public static final int WIDTH = 50, HEIGHT = 50;
        public GamePanel game;
        public int left, right;
        public int y;
        public int x, xa;

        public Player(GamePanel game, int left, int right, int x) {
            this.game = game;
            this.left = left;
            this.right = right;
            this.x = x;
            y = game.getHeight() - HEIGHT;
        }

        public void update() {
            if (x > 0 && x < game.getWidth() - WIDTH - 36) {
                x += xa;
            } else if (x == 0) {
                x++;
            } else if (x == game.getWidth() - WIDTH - 36) {
                x--;
            }
        }

        public void pressed(int keyCode) {
            if (keyCode == left) {
                xa = -1;
            } else if (keyCode == right) {
                xa = 1;
            }
        }

        public void released(int keyCode) {
            if (keyCode == left || keyCode == right) {
                xa = 0;
            }
        }

        public Rectangle getBounds() {
            return new Rectangle(x, y, WIDTH, HEIGHT);
        }

        public void paint(Graphics g) {
            System.out.println(x + "x" + y);
            g.fillRect(x, y, WIDTH, HEIGHT);
            g.setColor(Color.ORANGE);
        }
    }
}