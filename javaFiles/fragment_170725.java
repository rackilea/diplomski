import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GraphicsTest {

    public static void main(String[] args) {
        new GraphicsTest();
    }

    public GraphicsTest() {
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
                frame.add(new Screen());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public enum Scene {
        MENU,
        GAME
    }

    public class Screen extends JPanel implements Runnable {

        Thread thread = new Thread(this);

        private int FPS = 0;

        public Scene scene;

        private boolean running = false;

        @Override
        public void run() {
            long lastFrame = System.currentTimeMillis();
            int frames = 0;

            running = true;
            scene = Scene.MENU;

            while (running) {
                repaint();

                frames++;

                if (System.currentTimeMillis() - 1000 >= lastFrame) {
                    FPS = frames;
                    frames = 0;

                    lastFrame = System.currentTimeMillis();
                }
            }

            System.exit(0);
        }

        public Screen() {
            thread.start();
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.clearRect(0, 0, getWidth(), getHeight());

            g.drawString("FPS: " + FPS, 10, 10);

            if (scene == Scene.MENU) {
                g.setColor(Color.BLACK);

                g.fillRoundRect((getWidth() / 2) - 100, (getHeight() / 2) - 50, 200, 100, 25, 25);
            }
        }

    }
}