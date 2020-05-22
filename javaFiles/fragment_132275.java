import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Launcher {
    private static class Gui extends JFrame {
        final int width;
        final int height;
        final JPanel panel;
        final BufferedImage buffered_image;

        Gui(final String title, final int width, final int height) {
            this.width = width;
            this.height = height;
            this.buffered_image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            this.panel = new JPanel() {
                @Override
                public void paintComponent(final Graphics graphics) {
                    super.paintComponent(graphics);
                    graphics.drawImage(Gui.this.buffered_image, 0, 0, null);
                }
            };
            this.setTitle(title);
            this.setContentPane(this.panel);
            this.setSize(width, height);
            this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            this.setVisible(true);
        }

        void colorize(final Color color, final int x, final int y) {
            if ((x < 0) || (x >= this.width) || (y < 0) || (y >= this.height))
                return;
            this.buffered_image.setRGB(x, y, color.getRGB());
        }

        int getRGBAtCoordinates(final int x, final int y) {
            return this.buffered_image.getRGB(x, y);
        }
    }

    public static void main(final String args[]) {
        final List<Color> colors = new ArrayList<>();
        colors.add(new Color(0, 0, 0)); // black
        colors.add(new Color(7, 7, 7));
        colors.add(new Color(47, 15, 7));
        colors.add(new Color(71, 15, 7));
        colors.add(new Color(87, 23, 7));
        colors.add(new Color(103, 31, 7));
        colors.add(new Color(119, 31, 7));
        colors.add(new Color(143, 39, 7));
        colors.add(new Color(159, 47, 7));
        colors.add(new Color(175, 63, 7));
        colors.add(new Color(191, 71, 7));
        colors.add(new Color(199, 71, 7));
        colors.add(new Color(223, 79, 7));
        colors.add(new Color(223, 87, 7));
        colors.add(new Color(223, 87, 7));
        colors.add(new Color(215, 95, 7));
        colors.add(new Color(215, 103, 15));
        colors.add(new Color(207, 111, 15));
        colors.add(new Color(207, 119, 15));
        colors.add(new Color(207, 127, 15));
        colors.add(new Color(207, 135, 23));
        colors.add(new Color(199, 135, 23));
        colors.add(new Color(199, 143, 23));
        colors.add(new Color(199, 151, 31));
        colors.add(new Color(191, 159, 31));
        colors.add(new Color(191, 159, 31));
        colors.add(new Color(191, 167, 39));
        colors.add(new Color(191, 167, 39));
        colors.add(new Color(191, 175, 47));
        colors.add(new Color(183, 175, 47));
        colors.add(new Color(183, 183, 47));
        colors.add(new Color(183, 183, 55));
        colors.add(new Color(207, 207, 111));
        colors.add(new Color(223, 223, 159));
        colors.add(new Color(239, 239, 199));
        colors.add(new Color(255, 255, 255)); // white

        final Gui gui = new Gui("DOOM-like fire", 800, 800);

        final Color black = colors.get(0);
        final Color white = colors.get(colors.size() - 1);
        final Dimension dim = gui.getContentPane().getSize(); // get actual size, without title/borders
        for (int y = 0; y < dim.height; y++) {
            final Color clr = y < (dim.height - 1) ? black : white;
            for (int x = 0; x < dim.width; x++)
                gui.colorize(clr, x, y);
        }

        new Timer().schedule(new TimerTask() {
            final Random rnd = new Random();

            Color getColorAtIndex(final int index) {
                if (index < 0)
                    return colors.get(0); // minimal color is black
                return colors.get(index);
            }

            int getIndexOfColor(final int rgb) {
                for (int x = 0; x < colors.size(); x++)
                    if (colors.get(x).getRGB() == rgb)
                        return x;
                throw new RuntimeException("Color not found in the list!");
            }

            @Override
            public void run() {
                for (int x = 0; x < dim.width; x++) {
                    for (int y = 1; y < dim.height; y++) {
                        final int new_index = this.getIndexOfColor(gui.getRGBAtCoordinates(x, y)) - this.rnd.nextInt(2);
                        final int new_x = (x - this.rnd.nextInt(3)) + 1;
                        gui.colorize(this.getColorAtIndex(new_index), new_x, y - 1);
                    }
                }
                gui.repaint();
            }
        }, 0, 40); // start immediately and repeat every 40ms
    }
}