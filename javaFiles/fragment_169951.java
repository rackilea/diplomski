import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class ImagePixelsTest {
    public static void main(String[] args) {

        int w = 256;
        int h = 256;
        byte bgr[] = new byte[w * h * 3];
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                int index = (y * w + x) * 3;
                bgr[index + 0] = (byte) x;
                bgr[index + 1] = (byte) y;
                bgr[index + 2] = 0;
            }
        }

        final BufferedImage image = createImage(w, h, bgr);
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame f = new JFrame();
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.getContentPane().add(new JLabel(new ImageIcon(image)));
                f.pack();
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            }
        });
    }

    private static BufferedImage createImage(int w, int h, byte bgr[]) {
        BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);

        for (int y = h - 1; y >= 0; y--) {
            for (int x = 0; x < w; x++) {
                int index = (y * w + x) * 3;
                int b = bgr[index + 0];
                int g = bgr[index + 1];
                int r = bgr[index + 2];
                int rgb = ((r & 0x0ff) << 16) | ((g & 0x0ff) << 8) | (b & 0x0ff);
                image.setRGB(x, y, rgb);
            }
        }
        return image;
    }

}