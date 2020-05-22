import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.IndexColorModel;
import java.awt.image.MemoryImageSource;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/** @see http://stackoverflow.com/questions/7546025 */
public class ColorCycler {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new ColorCycler().create();
            }
        });
    }

    private void create() {
        JFrame jFrame = new JFrame("Color Cycler");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final ColorPanel cp = new ColorPanel();
        JPanel control = new JPanel();
        final JSpinner s = new JSpinner(
            new SpinnerNumberModel(cp.colorCount, 2, 256, 1));
        s.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                cp.setColorCount(((Integer) s.getValue()).intValue());
            }
        });
        control.add(new JLabel("Shades:"));
        control.add(s);
        jFrame.add(cp, BorderLayout.CENTER);
        jFrame.add(control, BorderLayout.SOUTH);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    private static class ColorPanel extends JPanel implements ActionListener {

        private static final int WIDE = 256;
        private static final int PERIOD = 40; // ~25 Hz
        private final Queue<IndexColorModel> models =
            new LinkedList<IndexColorModel>();
        private final MemoryImageSource imageSource;
        private final byte[] imageData = new byte[WIDE * WIDE];
        private final Image image;
        private int colorCount = 128;

        public ColorPanel() {
            generateColorModels();
            generateImageData();
            imageSource = new MemoryImageSource(
                WIDE, WIDE, models.peek(), imageData, 0, WIDE);
            imageSource.setAnimated(true);
            image = createImage(imageSource);
            (new Timer(PERIOD, this)).start();
        }

        // The preferred size is NxN pixels.
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(WIDE, WIDE);
        }

        public void setColorCount(int colorCount) {
            this.colorCount = colorCount;
            generateColorModels();
            generateImageData();
            repaint();
        }

        // Generate MODEL_SIZE unique color models.
        private void generateColorModels() {
            byte[] reds = new byte[colorCount];
            byte[] greens = new byte[colorCount];
            byte[] blues = new byte[colorCount];
            for (int i = 0; i < colorCount; i++) {
                reds[i] = (byte) (i * 256 / colorCount);
                greens[i] = (byte) (i * 256 / colorCount);
                blues[i] = (byte) (i * 256 / colorCount);
            }
            models.clear();
            for (int i = 0; i < colorCount; i++) {
                reds = rotateColors(reds);
                greens = rotateColors(greens);
                blues = rotateColors(blues);
                models.add(new IndexColorModel(
                    8, colorCount, reds, greens, blues));
            }
        }

        // Rotate colors to the right by one.
        private byte[] rotateColors(byte[] colors) {
            byte[] newColors = new byte[colors.length];
            newColors[0] = colors[colors.length - 1];
            System.arraycopy(colors, 0, newColors, 1, colors.length - 1);
            return newColors;
        }

        // Create some data for the MemoryImageSource.
        private void generateImageData() {
            for (int i = 0; i < imageData.length; i++) {
                imageData[i] = (byte) (i % colorCount);
            }
        }

        // Draw the image.
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            long start = System.nanoTime();
            imageSource.newPixels(imageData, models.peek(), 0, WIDE);
            models.add(models.remove());
            double delta = (System.nanoTime() - start) / 1000000d;
            g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
            g.drawString(String.format("%1$5.3f", delta), 5, 15);
        }

        // Called by the Timer every PERIOD ms.
        @Override
        public void actionPerformed(ActionEvent e) { // Called by Timer.
            repaint();
        }
    }
}