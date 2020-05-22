import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Test {

    /**
     * Default constructor Test.class
     */
    public Test() {
        initComponents();
    }

    public static void main(String[] args) {

        /**
         * Create GUI and components on Event-Dispatch-Thread
         */
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Test test = new Test();
            }
        });
    }

    /**
     * Initialize GUI and components (including ActionListeners etc)
     */
    private void initComponents() {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //add ImageComponent to JFrame instance
        jFrame.add(new ImageComponent());

        //pack frame (size JFrame to match preferred sizes of added components and set visible
        jFrame.pack();
        jFrame.setVisible(true);
    }
}

class ImageComponent extends JComponent {

    private Image image;
    public int width;
    public int height;

    public ImageComponent() {
        try {
            image = ImageUtils.scaleImage(300, 300, ImageIO.read(new URL("http://harmful.cat-v.org/software/_java/java-evil-edition.png")));
            //image =  ImageIO.read(new URL("http://harmful.cat-v.org/software/_java/java-evil-edition.png"));//uses images scale
        } catch (Exception e) {
            e.printStackTrace();
        }

        //so we can set the JPanel preferred size to the image width and height
        ImageIcon ii = new ImageIcon(image);
        width = ii.getIconWidth();
        height = ii.getIconHeight();
    }

    //so our panel is the same size as image
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (image == null) {
            return;
        }

        width = image.getWidth(this);
        height = image.getHeight(this);

        g.drawImage(image, 0, 0, null);
    }
}
//class used for scaling images
class ImageUtils {

    static Image scaleImage(int width, int height, BufferedImage filename) {
        BufferedImage bi;
        try {
            bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = (Graphics2D) bi.createGraphics();
            g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
            g2d.drawImage(filename, 0, 0, width, height, null);
        } catch (Exception e) {
            return null;
        }
        return bi;
    }
}