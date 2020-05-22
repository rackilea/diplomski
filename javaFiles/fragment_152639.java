import java.awt.*;
import java.awt.geom.Rectangle2D;

public final class TextBoundsCalculator {
    private interface MeasureStrategy {
        Rectangle2D boundsFor(String string, Graphics2D g);
    }

    private MeasureStrategy measureStrategy;

    private TextBoundsCalculator(MeasureStrategy measureStrategy) {
        this.measureStrategy = measureStrategy;
    }

    public static TextBoundsCalculator forFont(Font font) {
        if (font.getSize() == 0)
            return new TextBoundsCalculator(new ScaleMeasureStrategy(font));

        // The bug appears to be only when font.getSize()==0.
        // So there's no need to normalize, measure and scale with fonts
        // where this is not the case
        return new TextBoundsCalculator(new NormalMeasureStrategy(font));
    }

    public Rectangle2D boundsFor(String string, Graphics2D g) {
        return measureStrategy.boundsFor(string, g);
    }

    private static class ScaleMeasureStrategy implements MeasureStrategy {
        private final float scale;
        private final Font normalizedFont;

        public ScaleMeasureStrategy(Font font) {
            scale = font.getSize2D();
            normalizedFont = font.deriveFont(1f);
        }

        public Rectangle2D boundsFor(String string, Graphics2D g) {
            Rectangle2D bounds = NormalMeasureStrategy.boundsForFont(normalizedFont, string, g);
            return scaleRectangle2D(bounds, scale);
        }
    }

    private static class NormalMeasureStrategy implements MeasureStrategy {
        private final Font font;

        public NormalMeasureStrategy(Font font) {
            this.font = font;
        }

        public Rectangle2D boundsFor(String string, Graphics2D g) {
            return boundsForFont(font, string, g);
        }

        private static Rectangle2D boundsForFont(Font font, String string, Graphics2D g) {
            return font.getStringBounds(string, g.getFontRenderContext());
        }
    }

    private static Rectangle2D scaleRectangle2D(Rectangle2D rectangle2D, float scale) {
        return new Rectangle2D.Double(
                rectangle2D.getX() * scale,
                rectangle2D.getY() * scale,
                rectangle2D.getWidth() * scale,
                rectangle2D.getHeight() * scale);
    }
}