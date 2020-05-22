import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

class TexturedShape {

    public static BufferedImage getTexturedImage(
            BufferedImage src, Shape shp, int x, int y) {
        Rectangle r = shp.getBounds();
        // create a transparent image with 1 px padding.
        BufferedImage tmp = new BufferedImage(
                r.width+2,r.height+2,BufferedImage.TYPE_INT_ARGB);
        // get the graphics object
        Graphics2D g = tmp.createGraphics();
        // set some nice rendering hints
        g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING, 
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(
                RenderingHints.KEY_COLOR_RENDERING, 
                RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        // create a transform to center the shape in the image
        AffineTransform centerTransform = AffineTransform.
                getTranslateInstance(-r.x+1, -r.y+1);
        // set the transform to the graphics object
        g.setTransform(centerTransform);
        // set the shape as the clip
        g.setClip(shp);
        // draw the image
        g.drawImage(src, x, y, null);
        // clear the clip
        g.setClip(null);
        // draw the shape as an outline
        g.setColor(Color.RED);
        g.setStroke(new BasicStroke(1f));
        g.draw(shp);
        // dispose of any graphics object we explicitly create
        g.dispose();

        return tmp;
    }

    public static Shape getPointedShape(int points, int radius) {
        double angle = Math.PI * 2 / points;

        GeneralPath p = new GeneralPath();
        for (int ii = 0; ii < points; ii++) {
            double a = angle * ii;

            double x = (Math.cos(a) * radius) + radius;
            double y = (Math.sin(a) * radius) + radius;
            if (ii == 0) {
                p.moveTo(x, y);
            } else {
                p.lineTo(x, y);
            }
        }
        p.closePath();

        return p;
    }

    public static void main(String[] args) throws Exception {
        URL url = new URL("http://i.stack.imgur.com/7bI1Y.jpg");
        BufferedImage bi = ImageIO.read(url);
        Shape hxgn = getPointedShape(6, 32);
        final BufferedImage txtr = getTexturedImage(bi, hxgn, -200, -120);
        Runnable r = new Runnable() {
            @Override
            public void run() {

                JOptionPane.showMessageDialog(null,
                        new JLabel(new ImageIcon(txtr)));
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency
        SwingUtilities.invokeLater(r);
    }
}