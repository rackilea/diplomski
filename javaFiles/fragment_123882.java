import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PiRaster extends JPanel {

    private static final int W = 30;
    private static final int H = 30;
    private static List<Integer> pi = new ArrayList<Integer>();
    BufferedImage image;
    private int[] clut = {
        0x000000, 0x787878, 0x008B00, 0x00008B, 0x008B8B,
        0x008B00, 0xCDCD00, 0xFF4500, 0x8B0000, 0xFF0000
    };

    public PiRaster() {
        this.setPreferredSize(new Dimension(W * 16, H * 10));
        String s = ""
            + "31415926535897932384626433832795028841971693993751"
            + "05820974944592307816406286208998628034825342117067"
            + "98214808651328230664709384460955058223172535940812"
            + "84811174502841027019385211055596446229489549303819"
            + "64428810975665933446128475648233786783165271201909"
            + "14564856692346034861045432664821339360726024914127";
        for (int i = 0; i < s.length(); i++) {
            pi.add(s.charAt(i) - '0');
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        if (image == null) {
            image = (BufferedImage) createImage(W, H);
            int i = 0;
            for (int row = 0; row < H; row++) {
                for (int col = 0; col < W; col++) {
                    image.setRGB(col, row, clut[pi.get(i)]);
                    if (++i == pi.size()) {
                        i = 0;
                    }
                }
            }
        }
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new PiRaster());
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}