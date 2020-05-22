import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public class ImageViewComponent extends JComponent {

    private int updateInterval, updateCounter;
    private BufferedImage fullImage;
    private BufferedImage displayedImage;

    /**
     * @param width          The width of this component
     * @param height         The height of this component
     * @param ui             The higher, the less frequent the image will be updated
     */
    public ImageViewComponent(int width, int height, int ui) {
        setPreferredSize(new Dimension(width, height));
        this.updateInterval = ui;
        this.updateCounter = 0;
        this.fullImage = null;
        this.displayedImage = 
            new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    }

    public void setImage(int[] image, int width, int height) {

        // Note: The updateInvervall/updateCounter stuff COULD
        // probably also be done here...
        if (fullImage == null ||
            fullImage.getWidth() != width ||
            fullImage.getHeight() != height)
        {
            fullImage = new BufferedImage(
                width, height, BufferedImage.TYPE_INT_RGB);
        }
        fullImage.setRGB(0, 0, width, height, image, 0, width);
        scaleImage(fullImage, displayedImage);
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(displayedImage, 0, 0, this);
    }


    private static BufferedImage scaleImage(
        BufferedImage input, BufferedImage output)
    {
        double scaleX = (double) output.getWidth() / input.getWidth();
        double scaleY = (double) output.getHeight() / input.getHeight();
        AffineTransform affineTransform = 
            AffineTransform.getScaleInstance(scaleX, scaleY);
        AffineTransformOp affineTransformOp = 
            new AffineTransformOp(affineTransform, null);
        return affineTransformOp.filter(input, output);
    }    

}