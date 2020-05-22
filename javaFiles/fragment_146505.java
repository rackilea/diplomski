import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private String[] lines = new String[]{
            "You can never quit",
            "WINNERS",
            "never quit and quitters never win"
        };

        private Font baseFont;
        private Font largeFont;

        public TestPane() {
            baseFont = new Font("Arial", Font.BOLD, 24);
            largeFont = baseFont.deriveFont(80f);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
            g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

            TextLayout line1 = new TextLayout(lines[0], baseFont, g2d.getFontRenderContext());
            TextLayout line2 = new TextLayout(lines[1], largeFont, g2d.getFontRenderContext());
            TextLayout line3 = new TextLayout(lines[2], baseFont, g2d.getFontRenderContext());

            Rectangle2D bounds = line2.getBounds();
            double xPos = (getWidth() - bounds.getWidth()) / 2;
            double yPos = (getHeight() / 2) + (bounds.getHeight() / 2);

            Shape textLine2Shape = line2.getOutline(AffineTransform.getTranslateInstance(xPos, yPos));
            g2d.fill(textLine2Shape);

            double yOffset = yPos - bounds.getHeight();
            xPos = (getWidth() - line1.getBounds().getWidth()) / 2;
            Shape textLine1Shape = line1.getOutline(AffineTransform.getTranslateInstance(xPos, yOffset));
            g2d.fill(textLine1Shape);

            yOffset = yPos + line3.getBounds().getHeight();
            xPos = (getWidth() - line3.getBounds().getWidth()) / 2;
            g2d.fill(line3.getOutline(AffineTransform.getTranslateInstance(xPos, yOffset)));

            Rectangle2D textLine1Bounds = textLine1Shape.getBounds2D();
            Rectangle2D textLine2Bounds = textLine2Shape.getBounds2D();
            Area whole = new Area(new Rectangle2D.Double(textLine2Bounds.getX(), textLine1Bounds.getY(), textLine2Bounds.getWidth(), textLine1Bounds.getHeight()));
            whole.subtract(new Area(textLine1Bounds));

            g2d.setClip(whole);

            xPos = textLine2Bounds.getX();
            yPos = textLine1Bounds.getCenterY();

            g2d.draw(new Line2D.Double(xPos, yPos, xPos + textLine2Bounds.getWidth(), yPos));

            g2d.dispose();
        }

    }

}