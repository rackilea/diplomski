import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TestPanels {

    private static final boolean GRAY_SCALE = true;

    protected void initUI() {
        final JFrame frame = new JFrame(TestPanels.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel unmodifiablePanel = new JPanel(new GridBagLayout());
        JLabel label = new JLabel("Some unmodifiable test label");
        unmodifiablePanel.add(label);
        unmodifiablePanel.setBackground(Color.GREEN);
        JPanel wrappingPanel = new JPanel(new BorderLayout()) {
            private ColorConvertOp op = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
            private BufferedImage image;

            @Override
            public void paint(Graphics g) {
                if (!GRAY_SCALE) {
                    super.paint(g);
                    return;
                }
                BufferedImage bi = getImage();
                if (bi != null) {
                    Graphics big = bi.createGraphics();
                    super.paint(big);
                    big.dispose();
                    bi = op.filter(bi, null);
                    g.drawImage(bi, 0, 0, null);
                }
            }

            protected BufferedImage getImage() {
                if (image == null) {
                    if (getWidth() > 0 && getHeight() > 0) {
                        image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
                    }
                } else if (image.getWidth() != getWidth() || image.getHeight() != image.getHeight()) {
                    image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
                }
                return image;
            }

        };
        wrappingPanel.add(unmodifiablePanel);

        frame.add(wrappingPanel);
        frame.setSize(200, 200);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestPanels().initUI();
            }
        });
    }
}