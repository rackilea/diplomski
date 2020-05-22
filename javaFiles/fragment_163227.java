import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class Rotate extends JComponent {
    // Attributes
    private String route = null;
    private double degree = 0.0;

    // Constructor
    public Rotate(String route, double degree) {
        this.setRoute(route);
        this.setDegree(degree);
    }

    // Create a bufferedImage for the given route
    private BufferedImage getBufferedImage() {
        Image image = null;
        try {
            image = ImageIO.read(new File(getRoute()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (BufferedImage) image;
    }

    // Paint the image
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        AffineTransform at = AffineTransform.getRotateInstance(Math.toRadians(getDegree()));
        g2.setTransform(at);
        // Here I tried to calculate you must add the coordenates to start
        // drawing the image in your frame
        g2.drawImage(getBufferedImage(), 0, 0, null);
    }

    public double getDiagonal() {
        return Math.hypot(getBufferedImage().getWidth(), getBufferedImage().getHeight());
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public double getDegree() {
        return degree;
    }

    public void setDegree(double degree) {
        this.degree = degree;
    }

}