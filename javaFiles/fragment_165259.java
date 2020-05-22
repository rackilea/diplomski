import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.kaizen.core.ui.ImageUtilities;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
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
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new GridBagLayout());
            HighlightButton btn = new HighlightButton("Help");
            btn.setMargin(new Insets(20, 20, 20, 20));
            btn.setHighlight(new Color(255, 0, 0, 64));
            add(btn);

            btn = new HighlightButton("Help");
            btn.setMargin(new Insets(20, 20, 20, 20));
            btn.setHighlight(new Color(0, 255, 0, 64));
            add(btn);

            btn = new HighlightButton("Help");
            btn.setMargin(new Insets(20, 20, 20, 20));
            btn.setHighlight(new Color(0, 0, 255, 64));
            add(btn);

            btn = new HighlightButton("Help");
            btn.setMargin(new Insets(20, 20, 20, 20));
            add(btn);
        }

    }

    public class HighlightButton extends JButton {

        private Color highlight;

        public HighlightButton() {
            setOpaque(false);
        }

        public HighlightButton(String text) {
            super(text);
            setOpaque(false);
        }

        public void setHighlight(Color color) {
            if (color != highlight) {
                Color old = highlight;
                this.highlight = color;
                firePropertyChange("highlight", old, highlight);
                repaint();
            }
        }

        public Color getHighlight() {
            return highlight;
        }

        @Override
        protected void paintComponent(Graphics g) {
            Color highlight = getHighlight();
            if (highlight != null) {
                BufferedImage img = createCompatibleImage(getWidth(), getHeight(), Transparency.TRANSLUCENT);
                Graphics2D g2d = img.createGraphics();
                super.paintComponent(g2d);
                g2d.dispose();

                BufferedImage mask = generateMask(img, getHighlight(), 1f);
                g.drawImage(img, 0, 0, this);
                g.drawImage(mask, 0, 0, this);
            } else {
                super.paintComponent(g);
            }
        }

    }

    public static BufferedImage createCompatibleImage(int width, int height, int transparency) {
        BufferedImage image = getGraphicsConfiguration().createCompatibleImage(width, height, transparency);
        image.coerceData(true);
        return image;
    }

    public static GraphicsConfiguration getGraphicsConfiguration() {
        return GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
    }

    public static BufferedImage generateMask(BufferedImage imgSource, Color color, float alpha) {

        int imgWidth = imgSource.getWidth();
        int imgHeight = imgSource.getHeight();

        BufferedImage imgMask = createCompatibleImage(imgWidth, imgHeight, Transparency.TRANSLUCENT);
        Graphics2D g2 = imgMask.createGraphics();
        applyQualityRenderingHints(g2);

        g2.drawImage(imgSource, 0, 0, null);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_IN, alpha));
        g2.setColor(color);

        g2.fillRect(0, 0, imgSource.getWidth(), imgSource.getHeight());
        g2.dispose();

        return imgMask;

    }

    public static void applyQualityRenderingHints(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
    }

}