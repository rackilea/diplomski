import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class RotateImageWithoutBorder
{
    public static void main(String[] args) throws Exception
    {
        BufferedImage image = 
            ImageIO.read(new URL("https://i.stack.imgur.com/tMtFh.png"));


        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImagePanel imagePanel0 = new ImagePanel();
        imagePanel0.setBackground(Color.BLUE);

        ImagePanel imagePanel1 = new ImagePanel();
        imagePanel1.setBackground(Color.BLUE);

        JSlider slider = new JSlider(0, 100, 1);
        slider.addChangeListener(e -> 
        {
            double alpha = slider.getValue() / 100.0;
            double angleRad = alpha * Math.PI * 2;

            BufferedImage rotatedImage = rotateImage(
                image, angleRad, Color.RED);
            imagePanel0.setImage(rotatedImage);

            BufferedImage rotatedImageInPlace = rotateImageInPlace(
                image, angleRad, Color.RED);
            imagePanel1.setImage(rotatedImageInPlace);

            f.repaint();
        });
        slider.setValue(0);
        f.getContentPane().add(slider, BorderLayout.SOUTH);

        JPanel imagePanels = new JPanel(new GridLayout(1,2));
        imagePanels.add(imagePanel0);
        imagePanels.add(imagePanel1);
        f.getContentPane().add(imagePanels, BorderLayout.CENTER);

        f.setSize(800,500);
        f.setLocationRelativeTo(null);
        f.setVisible(true);

    }

    private static BufferedImage rotateImage(
        BufferedImage image, double angleRad, Color backgroundColor)
    {
        int w = image.getWidth();
        int h = image.getHeight();
        AffineTransform at = AffineTransform.getRotateInstance(
            angleRad, w * 0.5, h * 0.5);
        Rectangle rotatedBounds = at.createTransformedShape(
            new Rectangle(0, 0, w, h)).getBounds();
        BufferedImage result = new BufferedImage(
            rotatedBounds.width, rotatedBounds.height, 
            BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = result.createGraphics();
        g.setColor(backgroundColor);
        g.fillRect(0, 0, rotatedBounds.width, rotatedBounds.height);
        at.preConcatenate(AffineTransform.getTranslateInstance(
            -rotatedBounds.x, -rotatedBounds.y));
        g.transform(at);
        g.setRenderingHint(
            RenderingHints.KEY_INTERPOLATION, 
            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return result;        
    }

    private static BufferedImage rotateImageInPlace(
        BufferedImage image, double angleRad, Color backgroundColor)
    {
        int w = image.getWidth();
        int h = image.getHeight();
        AffineTransform at = AffineTransform.getRotateInstance(
            angleRad, w * 0.5, h * 0.5);
        Rectangle rotatedBounds = at.createTransformedShape(
            new Rectangle(0, 0, w, h)).getBounds();
        BufferedImage result = new BufferedImage(
            w, h, 
            BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = result.createGraphics();
        g.setColor(backgroundColor);
        g.fillRect(0, 0, w, h);
        at.preConcatenate(AffineTransform.getTranslateInstance(
            -rotatedBounds.x - (rotatedBounds.width - w) * 0.5, 
            -rotatedBounds.y - (rotatedBounds.height - h) * 0.5));
        g.transform(at);
        g.setRenderingHint(
            RenderingHints.KEY_INTERPOLATION, 
            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return result;        
    }


    static class ImagePanel extends JPanel
    {
        private BufferedImage image;

        public void setImage(BufferedImage image)
        {
            this.image = image;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            if (image != null)
            {
                g.drawImage(image, 0, 0, null);
            }
        }
    }
}