import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import javafx.scene.Scene;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

public class TowerDefense extends JFrame {

    public static void main(String[] args) {
        new TowerDefense();
    }

    public TowerDefense() {
//        setExtendedState(MAXIMIZED_BOTH);
//        setUndecorated(true);
        setTitle("Tower Defense");

        setDefaultCloseOperation(EXIT_ON_CLOSE);

//        setResizable(false);

        Screen screen = new Screen(this);
        this.add(screen);
        pack();

        setVisible(true);
    }

    public enum Scene {
        MENU,
        GAME
    }

    public class Screen extends JPanel implements Runnable {

        Thread thread = new Thread(this);

        private int FPS = 0;

        public Scene scene;

        TowerDefense tD;

        private boolean running = false;

        public RoundRectangle2D.Float playGame, quitGame;
        public boolean playGameHighlighted, quitGameHighlighted;

        @Override
        public void run() {
//            long lastFrame = System.currentTimeMillis();
//            int frames = 0;
//
//            running = true;
//
//            while (running) {
//                repaint();
//
//                frames++;
//
//                if (System.currentTimeMillis() - 1000 >= lastFrame) {
//                    FPS = frames;
//                    frames = 0;
//
//                    lastFrame = System.currentTimeMillis();
//                }
//            }
//
//            System.exit(0);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }

        public Screen(TowerDefense tD) {
            thread.start();

            addKeyListener(new KeyHandler(this));
            addMouseMotionListener(
                    new MouseAdapter() {

                @Override
                public void mouseMoved(MouseEvent e) {
                    playGameHighlighted = playGame.contains(e.getPoint());
                    quitGameHighlighted = quitGame.contains(e.getPoint());
                    repaint();
                }
            });

            this.tD = tD;
            scene = Scene.MENU;

        }

        @Override
        public void paintComponent(Graphics g2) {
            super.paintComponent(g2);

            playGame = new RoundRectangle2D.Float((getWidth() / 2) - 200, (getHeight() / 2) - 100, 400, 100, 10, 10);
            quitGame = new RoundRectangle2D.Float((getWidth() / 2) - 200, (getHeight() / 2) + 20, 400, 100, 10, 10);

            Graphics2D g = (Graphics2D) g2.create();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g.clearRect(0, 0, getWidth(), getHeight());

            g.drawString("FPS: " + FPS, 10, 10);

            if (scene == Scene.MENU) {
                if (playGameHighlighted) {
                    g.setColor(new Color(255, 152, 56));
                } else {
                    g.setColor(new Color(4, 47, 61));
                }
                g.draw(playGame);

                if (quitGameHighlighted) {
                    g.setColor(new Color(255, 152, 56));
                } else {
                    g.setColor(new Color(4, 47, 61));
                }
                g.draw(quitGame);

                g.setColor(Color.WHITE);
                g.setFont(new Font("Gisha", Font.PLAIN, 20));
                g.drawString("Play", (getWidth() / 2) - (g.getFontMetrics().stringWidth("Play") / 2), (getHeight() / 2) - 45);
                g.drawString("Quit", (getWidth() / 2) - (g.getFontMetrics().stringWidth("Quit") / 2), (getHeight() / 2) + 75);
            }
        }

        public class KeyTyped {

            public void keyESC() {
                running = false;
            }
        }

    }

    public class KeyHandler implements KeyListener {

        private Screen screen;
        private Screen.KeyTyped keyTyped;

        public KeyHandler(Screen screen) {
            this.screen = screen;

            keyTyped = screen.new KeyTyped();
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == 27) {
                keyTyped.keyESC();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

    }
}