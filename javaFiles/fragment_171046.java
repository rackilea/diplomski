import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new PixelReloc());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class Pixel {

        private int x, y;
        private int color;

        public Pixel(int x, int y, int color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getColor() {
            return color;
        }

    }

    public class PixelReloc extends JComponent {

        private BufferedImage image;
        private BufferedImage newImg;

        public PixelReloc() {

            SwingWorker<Integer[], List<Pixel>> worker = new SwingWorker<Integer[], List<Pixel>>() {
                Integer pixels[];

                @Override
                protected Integer[] doInBackground() throws Exception {
                    pixels = new Integer[image.getWidth() * image.getHeight()];
                    int index = 0;
                    List<Pixel> pixies = new ArrayList<>(image.getWidth());
                    for (int y = 0; y < image.getHeight(); y++) {
                        for (int x = 0; x < image.getWidth(); x++) {
                            int color = image.getRGB(x, y);
                            pixels[index++] = color;
                            pixies.add(new Pixel(x, y, color));
                        }
                        publish(new ArrayList<Pixel>(pixies));
                        pixies = new ArrayList<>(image.getWidth());
                        Thread.sleep(100);
                    }
                    return pixels;
                }

                @Override
                protected void process(List<List<Pixel>> chunks) {
                    for (List<Pixel> pixels : chunks) {
                        for (Pixel pixel : pixels) {
                            newImg.setRGB(pixel.getX(), pixel.getY(), pixel.getColor());
                        }
                    }
                    repaint();
                }

            };

            File f = new File("/Volumes/Big Fat Extension/Dropbox/MegaTokyo/chaotic_megatokyo_by_fredrin-d9k84so.jpg");
            try {
                image = ImageIO.read(f);
            } catch (IOException e) {
            }
            System.out.println("checkpoint 1");
            image = createResizedCopy(image, 200, 200, true);
            newImg = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
            worker.execute();
            //          pixels = new int[(image.getWidth()) * (image.getHeight())];
            //          System.out.println("checkpoint 2");
            //          for (i = 0; i < newImg.getWidth(); i++) {
            //              for (j = 0; j < newImg.getHeight(); j++) {
            //                  //get the rgb color of the old image
            //                  Color c = new Color(image.getRGB(i, j));
            //                  int r = c.getRed();
            //                  int g = c.getGreen();
            //                  int b = c.getBlue();
            //                  pixels[index++] = (r << 16) | (g << 8) | b;
            //              }
            //          }
            //          System.out.println("checkpoint 4");
            //image.setRGB(0, 0, width, height, data, 0, width);
        }

        @Override
        public Dimension getPreferredSize() {
            return image == null ? new Dimension(200, 200) : new Dimension(image.getWidth(), image.getHeight());
        }

        public BufferedImage createResizedCopy(BufferedImage originalImage,
                        int scaledWidth, int scaledHeight,
                        boolean preserveAlpha) {
            System.out.println("resizing...");
            Image scaled = originalImage.getScaledInstance(scaledWidth, -1, Image.SCALE_SMOOTH);
            BufferedImage scaledBI = new BufferedImage(scaled.getWidth(null), scaled.getHeight(null), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = scaledBI.createGraphics();
            g.drawImage(scaled, 0, 0, null);
            g.dispose();
            return scaledBI;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(newImg, 0, 0, this);
        }

    }
}