import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Test2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JPanel p = new JPanel();
        p.setPreferredSize(new Dimension(400, 400));
        p.setOpaque(false);
        JButton button = new JButton("Hello world");
        p.add(button);
        frame.add(p);
        frame.pack();
        frame.setVisible(true);
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                BufferedImage bufImage = new BufferedImage(p.getWidth(), p.getHeight(), java.awt.image.BufferedImage.TYPE_INT_ARGB);
                Graphics2D graphics = bufImage.createGraphics();
                p.print(graphics);
                graphics.dispose();
                try {
                    ImageIO.write(bufImage, "png", new File("d:/tmp/tmp.png"));
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }
}