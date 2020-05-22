import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

public class DoubleBuffer {

    public static void main(String[] args) {

        Pan game = new Pan();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.add(game);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        game.start();

    }

    public static class Pan extends Canvas implements Runnable {

        private int xDelta = 2;
        private int x = 0;
        private int y = 20;

        public Pan() {
        }

        public void start() {
            new Thread(this).start();
        }

        public void run() {

            while (true) {
                update();
                try {
                    Thread.sleep(40);
                } catch (InterruptedException ex) {
                }
                draw();
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        public void update() {
            x += xDelta;
            if (x + 20 > getWidth()) {
                x = getWidth() - 20;
                xDelta *= -1;
            } else if (x < 0) {
                x = 0;
                xDelta *= -1;
            }
        }

        public void draw() {
            BufferStrategy bs = getBufferStrategy();
            if (bs == null) {
                createBufferStrategy(3);
                return;
            }

            Graphics g = bs.getDrawGraphics();
            g.setColor(Color.RED);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.BLACK);
            g.fillOval(x, y, 20, 20);
            g.dispose();
            bs.show();
        }
    }
}