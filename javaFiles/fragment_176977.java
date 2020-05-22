import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

class CombineImages {

    public static void main(String[] args) throws Exception {
        URL urlImage1 = new URL("http://i.stack.imgur.com/T5uTa.png");
        // Load the FG image (must have transparent parts)
        final Image fgImage = ImageIO.read(urlImage1);
        int w = fgImage.getWidth(null);
        int h = fgImage.getHeight(null);
        // Create a non-trasparent BG image
        final BufferedImage bgImage =
                new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
        // Create the final image
        final BufferedImage finalImage =
                new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
        Graphics2D g = finalImage.createGraphics();
        g.drawImage(bgImage, 0, 0, null);
        g.drawImage(fgImage, 0, 0, null);
        g.dispose();

        Runnable r = new Runnable() {

            @Override
            public void run() {
                JPanel gui = new JPanel(new GridLayout(1,0,5,5));

                gui.add(new JLabel(new ImageIcon(bgImage)));
                gui.add(new JLabel(new ImageIcon(fgImage)));
                gui.add(new JLabel(new ImageIcon(finalImage)));

                JOptionPane.showMessageDialog(null, gui);
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency/initial.html
        SwingUtilities.invokeLater(r);
    }
}