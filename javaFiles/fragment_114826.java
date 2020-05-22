import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class SSCCEPaintInvisible
{
    public static void main(String[] args)
    {
        /* Create an JPanel with a JLabel */
        JPanel panel = new JPanel();

        JLabel label = new JLabel("Hello World");
        panel.add(label);
        // Next 3 are very important!
        panel.setSize(panel.getPreferredSize());
        panel.addNotify();
        panel.doLayout();

        /* Record a picture of the panel */
        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics g = image.getGraphics();

        /* Draw something to ensure we're drawing */
        g.setColor(Color.BLACK);
        g.drawLine(0, 0, 100, 100);

        /* Attempt to draw the panel we created earlier */
        panel.paintAll(g);  // DOES NOTHING. :(

        /* Display a frame to test if the graphics was captured */
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label2 = new JLabel( new ImageIcon(image) );
        frame.add(label2);
        frame.pack();

        frame.setVisible(true);
            // shows ONLY the black line we drew in the Graphics
    }
}