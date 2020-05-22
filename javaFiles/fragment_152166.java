import java.net.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

class FallingShapes implements Runnable {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new FallingShapes());
    }

    @Override
    public void run() {
        List<Entity> entities = new ArrayList<Entity>();

        int w = 0;
        int h = 0;

        for (BufferedImage img : Resources.images) {
            entities.add(new Entity(img));

            w += img.getWidth();
            h += img.getHeight();
        }

        PaintPanel p = new PaintPanel(entities);
        p.setPreferredSize(new Dimension(w, (2 * h)));

        JFrame f = new JFrame();

        f.setContentPane(p);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        new Animator((1000 / 60), p, entities).start();
    }

    static class Animator implements ActionListener {
        int period;
        JPanel context;
        int height;
        List<Entity> entities;

        Animator(int period, JPanel context, List<Entity> entities) {
            this.context  = context;
            this.height   = context.getHeight();
            this.period   = period;
            this.entities = entities;
        }

        @Override
        public void actionPerformed(ActionEvent a) {
            for (Entity e : entities) {
                double dist =
                    (period / 1000.0) * (height * e.rate);

                e.y += dist;
                e.y %= height;
            }

            context.repaint();
        }

        void start() {
            Random r = new Random();
            int    x = 0;
            for (Entity e : entities) {
                e.x    = x;
                e.y    = r.nextInt(height);
                e.rate = (0.25 + (0.75 * r.nextDouble()));

                x += e.width;
            }

            new Timer(period, this).start();
        }
    }

    static class Entity {
        BufferedImage img;

        double x, y, rate;
        int width, height;

        Entity(BufferedImage img) {
            this.img    = img;
            this.width  = img.getWidth();
            this.height = img.getHeight();
        }

        void paint(Graphics g, JPanel context) {
            int x = (int) Math.round(this.x);
            int y = (int) Math.round(this.y);
            g.drawImage(img, x, y, null);

            int cHeight = context.getHeight();
            if ((y + height) > cHeight) {
                g.drawImage(img, x, y - cHeight, null);
            }
        }
    }

    static class PaintPanel extends JPanel {
        List<Entity> entities;

        PaintPanel(List<Entity> entities) {
            this.entities = entities;

            setBackground(Color.white);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            for (Entity e : entities) {
                e.paint(g, this);
            }
        }
    }

    static class Resources {
        static final String[] paths = {
            "http://i.stack.imgur.com/wCF8S.png",
            "http://i.stack.imgur.com/5v2TX.png",
            "http://i.stack.imgur.com/F0JHK.png",
            "http://i.stack.imgur.com/4EVv1.png",
            "http://i.stack.imgur.com/xj49g.png",
        };

        static final List<BufferedImage> images =
            new ArrayList<BufferedImage>();
        static {
            for (String path : paths) {
                try {
                    images.add(ImageIO.read(new URL(path)));
                } catch (Exception e) {
                    throw new AssertionError(e);
                }
            }
        }
    }
}