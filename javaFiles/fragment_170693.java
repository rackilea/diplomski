import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) throws MalformedURLException, IOException {
        JFrame frame = new JFrame();
        Box box = new Box(BoxLayout.Y_AXIS);
        BufferedImage image = ImageIO.read(new URL("http://sstatic.net/so/img/logo.png"));
        AffineTransform xfrm1 = AffineTransform.getScaleInstance(0.95, 1.25);
        xfrm1.rotate(-0.3);
        box.add(new ImageView(image, xfrm1));
        AffineTransform xfrm2 = AffineTransform.getShearInstance(0.1, 0.2);
        xfrm2.scale(1.3, 0.9);
        box.add(new ImageView(image, xfrm2));
        frame.add(box);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

@SuppressWarnings("serial")
class ImageView extends JComponent {
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        try {
            paintXfrm = g2d.getTransform();
            paintXfrm.invert();
            g2d.translate(getWidth() / 2, getHeight() / 2);
            g2d.transform(xfrm);
            g2d.translate(image.getWidth() * -0.5, image.getHeight() * -0.5);
            paintXfrm.concatenate(g2d.getTransform());
            g2d.drawImage(image, 0, 0, this);
        } catch (NoninvertibleTransformException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(image.getWidth() * 2, image.getHeight() * 2);
    }

    ImageView(final BufferedImage image, final AffineTransform xfrm) {
        this.canvas = image.createGraphics();
        canvas.setColor(Color.BLACK);
        canvas.setStroke(new BasicStroke(3.0f));
        this.image = image;
        this.xfrm = xfrm;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    mouseDownCoord = e.getPoint();
                    paintXfrm.inverseTransform(mouseDownCoord, mouseDownCoord);
                } catch (NoninvertibleTransformException ex) {
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mouseDownCoord = null;
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Point p = e.getPoint();
                try {
                    paintXfrm.inverseTransform(p, p);
                    if (mouseDownCoord != null) {
                        canvas.drawLine(mouseDownCoord.x, mouseDownCoord.y, p.x, p.y);
                        for (Component sibling: getParent().getComponents()) {
                            sibling.repaint();
                        }
                    }
                    mouseDownCoord = p;
                } catch (NoninvertibleTransformException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private Graphics2D canvas;
    private BufferedImage image;
    private AffineTransform xfrm;
    private AffineTransform paintXfrm;
    private Point mouseDownCoord;
}