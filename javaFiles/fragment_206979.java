import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.RenderingHints;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.io.File;
import java.util.*;
import javax.imageio.ImageIO;

public class ShapeContainment {

    List<Ellipse2D> shapes = new ArrayList<Ellipse2D>();
    int w = 400;
    int h = 100;
    BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
    Point2D mouse = new Point2D.Double(0, 0);
    JLabel l;

    ShapeContainment() {
        Random r = new Random();
        for (int ii = 0; ii < 10; ii++) {
            int x = r.nextInt(w / 2);
            int y = r.nextInt(h / 2);
            int wE = r.nextInt(w - x);
            int hE = r.nextInt(h - y);
            Ellipse2D ellipse = new Ellipse2D.Double(x, y, wE, hE);
            shapes.add(ellipse);
        }
        l = new JLabel(new ImageIcon(img));
        MouseAdapter listener = new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                mouse = me.getPoint();
                drawImage();
            }
        };
        l.addMouseListener(listener);
        drawImage();

        JOptionPane.showMessageDialog(null, l);
    }

    public void drawImage() {
        Graphics2D g = img.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, w, h);

        RenderingHints hints = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHints(hints);

        Color bg = new Color(0, 128, 0, 60);
        Color inside = new Color(0, 0, 255, 120);
        Color outside = new Color(255, 0, 0, 120);
        g.setStroke(new BasicStroke(4));
        for (Ellipse2D shape : shapes) {
            g.setColor(bg);
            g.fill(shape);
            if (shape.contains(mouse)) {
                g.setColor(inside);
            } else {
                g.setColor(outside);
            }
            g.draw(shape);
        }
        g.setColor(Color.RED);
        int x = (int) mouse.getX();
        int y = (int) mouse.getY();
        g.setStroke(new BasicStroke(2));
        int s = 3;
        g.drawLine(x-s, y, x+s, y);
        g.drawLine(x, y-s, x, y+s);
        l.setIcon(new ImageIcon(img));

        g.dispose();

        try {
            ImageIO.write(
                    img,
                    "png",
                    new File(System.currentTimeMillis() + ".png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Runnable run = new Runnable() {

            @Override
            public void run() {
                new ShapeContainment();
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency/initial.html
        SwingUtilities.invokeLater(run);
    }
}