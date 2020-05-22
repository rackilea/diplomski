import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class WannaBeStreetFighter extends JPanel {

    private static final int D_W = 700, D_H = 250, X_INC = 10;

    private final List<Fireball> fireBalls;
    private BufferedImage ryu, background;
    private final Random rand = new Random();

    public WannaBeStreetFighter() {

        try {
            //fighter image
            ryu = ImageIO.read(new URL("https://static1.squarespace.com/static/50f14d35e4b0d70ab5fc4f24/t/53f3260de4b0a13f9746a07c/1408443920310/ryu_hadoken_pose.png"));
            background = ImageIO.read(new URL("http://fightingstreet.com/folders/variousinfofolder/ehondasbath/hondasfz3stage.gif"));
        } catch (IOException ex) {  ex.printStackTrace();   }

        fireBalls = new LinkedList<>();

        Timer timer = new Timer(40, e -> {

            Iterator<Fireball> it = fireBalls.iterator();

            while (it.hasNext()) {
                Fireball ball = it.next();
                if (ball.x > D_W) {
                    it.remove();
                } else {
                    ball.x += X_INC;
                    repaint();
                }
            }

            addBalls();
        });

        timer.start();
    }

    private void addBalls() {

        if(rand.nextInt(100) > 5)  return; //reduce the frequency of adding balls
        fireBalls.add(new Fireball());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, D_W, D_H, this);
        g.drawImage(ryu, 50, 125, 150, 115, this);
        for (Fireball ball : fireBalls) {
            ball.drawFireball(g);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(D_W, D_H);
    }

    private class Fireball {

        private final Image fireball;
        private int x = 180;       
        private final int y = 140;
        private static final int SIZE =25;

        public Fireball() {
            fireball = getBall();
        }

        public void drawFireball(Graphics g) {
            g.drawImage(fireball, x, y, 25, 25, null);
        }

        private BufferedImage getBall() {
            BufferedImage img = new BufferedImage(SIZE , SIZE,
                                                BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = img.createGraphics();
            g2.setColor(Color.RED);
            g2.fillOval(1, 1, SIZE - 2, SIZE - 2);
            g2.dispose();
            return img;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Best Street Fighter ever");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new WannaBeStreetFighter());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}