import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.List;
import java.util.logging.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.Timer;

public class WannaBeStreetFighter extends JPanel {

    private static final int D_W = 700;
    private static final int D_H = 250;
    private static final int X_INC = 10;

    List<Fireball> fireBalls;
    BufferedImage ryu;
    BufferedImage fireball;
    BufferedImage background;

    public WannaBeStreetFighter() {

        try {
            ryu = ImageIO.read(new URL("http://www.sirlin.net/storage/street_fighter/ryu_hadoken_pose.png?__SQUARESPACE_CACHEVERSION=1226531909576"));
            background = ImageIO.read(new URL("http://fightingstreet.com/folders/variousinfofolder/ehondasbath/hondasfz3stage.gif"));
            fireball = ImageIO.read(new URL("http://farm6.staticflickr.com/5480/12297371495_ec19ded155_o.png"));
        } catch (IOException ex) {
            Logger.getLogger(WannaBeStreetFighter.class.getName()).log(Level.SEVERE, null, ex);
        }

        fireBalls = new LinkedList<>();

        Timer timer = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Iterator<Fireball> it = fireBalls.iterator();
                while (it.hasNext()) {
                    Fireball ball = it.next();
                    if (ball.x > D_W) {
                        it.remove();
                        System.out.println(fireBalls.size());
                    } else {
                        ball.x += X_INC;
                        repaint();
                    }
                }
            }
        });
        timer.start();

        InputMap inputMap = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke("SPACE"), "hadouken");
        getActionMap().put("hadouken", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireBalls.add(new Fireball(fireball));
            }
        });

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

        Image fireball;
        int x = 150;
        int y = 125;

        public Fireball(Image image) {
            fireball = image;
        }

        public void drawFireball(Graphics g) {
            g.drawImage(fireball, x, y, 75, 50, null);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Best Street Fighter ever");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new WannaBeStreetFighter());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}