import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.net.*;

class ColorModelEx implements Runnable {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new ColorModelEx());
    }

    @Override
    public void run() {
        JFrame frame = new JFrame();
        JLabel label;
        try {
            label = new JLabel(new ImageIcon(createImage(
                Color.yellow, Color.red, Color.blue)));
        } catch (Exception e) {
            throw new AssertionError(e);
        }

        frame.add(label);
        frame.pack();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    static BufferedImage createImage(Color... colors) throws Exception {
        if ((256 % (colors.length - 1)) != 0)
            throw new IllegalArgumentException();

        BufferedImage original =
            ImageIO.read(new URL("http://i.stack.imgur.com/7bI1Y.jpg"));

        final int w = original.getWidth();
        final int h = original.getHeight();

        BufferedImage gray =
            new BufferedImage(w, h, BufferedImage.TYPE_BYTE_GRAY);
        Graphics2D g2 = gray.createGraphics();
        g2.drawImage(original, 0, 0, null);

        byte[] r = new byte[256];
        byte[] g = new byte[256];
        byte[] b = new byte[256];

        final int fade = (256 / (colors.length - 1));

        // (generate all 256 RGB values by
        // fading between the colors supplied)
        for (int i = 0; i < 256; ++i) {
            Color c0 = colors[(i / fade)];
            Color c1 = colors[(i / fade) + 1];

            float amt = (i % fade) / ((float) fade);

            r[i] = getChannel(amt, c0.getRed(),   c1.getRed());
            g[i] = getChannel(amt, c0.getGreen(), c1.getGreen());
            b[i] = getChannel(amt, c0.getBlue(),  c1.getBlue());
        }

        // (remap same pixels to new model)
        return new BufferedImage(
            new IndexColorModel(8, 256, r, g, b),
            gray.getRaster(), false, null);
    }

    static byte getChannel(float amt, int ch0, int ch1) {
        return (byte)
            ((ch0 * (1 - amt)) + (ch1 * amt));
    }
}