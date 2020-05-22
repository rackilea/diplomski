import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class Test extends Applet implements Runnable {

    private static final long serialVersionUID = 1L;

    private final int SIZE = 50;
    private final int VELOCITY = 1;

    private int x = 5, velX = VELOCITY;
    private int y = 5, velY = VELOCITY;


    @Override
    public void init() {
        this.setSize(800, 600);
    }

    @Override
    public void run() {
        while (true) {
            x += velX;
            if (x > this.getWidth() - SIZE) {
                x = 2*(this.getWidth() - SIZE)-x;
                velX = -velX;
            }
            else if (x < 0) {
                x = -x;
                velX = -velX;
            }

            y += velY;
            if (y > this.getHeight() - SIZE) {
                y = 2*(this.getHeight() - SIZE)-y;
                velY = -velY;
            }
            else if (y < 0) {
                y = -y;
                velY = -velY;
            }
            repaint();
            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void start() {
        new Thread(this).start();
    }

    @Override
    public void stop() {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void update(Graphics g)
    {
        g.clearRect(
                x - VELOCITY,
                y - VELOCITY,
                SIZE+2*VELOCITY,
                SIZE+2*VELOCITY
        );
        paint(g);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillOval(x, y, SIZE, SIZE);
    }
}