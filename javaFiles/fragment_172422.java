import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

/**
 *
 * @author francesc
 */

public class Game extends JPanel implements KeyListener, Runnable {
    public static final long SerialVersionUID = 1L;
    public static final int WIDTH = 400;
    public static final int HEIGHT = 630;
    public static final Font main = new Font("Bebas Nue Regular", Font.PLAIN, 28);
    private Thread game;
    private boolean running;
    private BufferedImage Image  = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

    private long startTime;
    private long elapse;
    private boolean set;

    public Game() {
        setFocusable(true);
        setPreferredSize(new Dimension(WIDTH, HEIGHT)); 
        addKeyListener(this);
    }
    private void update() {}
    private void render() {
        Graphics2D g = (Graphics2D) Image.getGraphics();
        g.setColor(Color.white);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        // render board 
        g.dispose();

        Graphics2D g2d = (Graphics2D) getGraphics();
        g2d.drawImage(Image, 0, 0, null);
        g2d.dispose();

    }
    @Override
    public void run() {
        int fps = 0, update = 0;
        long fpsTimer = System.currentTimeMillis();
        double nsPerUpdate = 1000000000.0 / 60;
        // last update time in nano seconds   
        double then = System.nanoTime();
        double unprocessed = 0;

        while (running) {

            boolean shouldRender = false;
            double now = System.nanoTime();
            unprocessed += (now - then) / nsPerUpdate;
            then = now;

            // update queque 
            while (unprocessed >= 1) {
                update++;
                update();
                unprocessed--;
                shouldRender = true;
            }
            // render 
            if (shouldRender) {
                fps++;
                render();
                shouldRender = false;
            } else {
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public synchronized start(){ 
        if(running)return; 
        running = true; 
        game = new Thread (this, "game");
        game.start();

    }
    public synchronized stop (){ 
        if(!running) return; 
        running = false; 
        System.exit(0);
    }
    @Override
        public void keyTyped(KeyEvent e) {
    }
    @Override
        public void keyPressed(KeyEvent e) {
    }
    @Override
        public void keyReleased(KeyEvent e) {
    }
}