import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.RenderingHints.Key;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.text.AttributedCharacterIterator;
import java.util.Map;

/**
 *
 * @author fortran
 */
public class Graphics2DWrapper extends Graphics2D {

    private final Graphics2D delegate;

    public Graphics2DWrapper(Graphics2D delegate) {
        this.delegate = delegate;
    }

    public String toString() {
        return delegate.toString();
    }

    public void setXORMode(Color c1) {
        delegate.setXORMode(c1);
    }

    public void setPaintMode() {
        delegate.setPaintMode();
    }

    public void setFont(Font font) {
        delegate.setFont(font);
    }

    public void setColor(Color c) {
        delegate.setColor(c);
    }

    public void setClip(Shape clip) {
        //ignore
    }

    public void setClip(int x, int y, int width, int height) {
        //ignore
    }

    public boolean hitClip(int x, int y, int width, int height) {
        return delegate.hitClip(x, y, width, height);
    }

    public FontMetrics getFontMetrics(Font f) {
        return delegate.getFontMetrics(f);
    }

    public FontMetrics getFontMetrics() {
        return delegate.getFontMetrics();
    }

    public Font getFont() {
        return delegate.getFont();
    }

    public Color getColor() {
        return delegate.getColor();
    }

    public Rectangle getClipRect() {
        return delegate.getClipRect();
    }

    public Rectangle getClipBounds(Rectangle r) {
        return delegate.getClipBounds(r);
    }

    public Rectangle getClipBounds() {
        return delegate.getClipBounds();
    }

    public Shape getClip() {
        return delegate.getClip();
    }

    public void finalize() {
        delegate.finalize();
    }

    public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
        delegate.fillRoundRect(x, y, width, height, arcWidth, arcHeight);
    }

    public void fillRect(int x, int y, int width, int height) {
        delegate.fillRect(x, y, width, height);
    }

    public void fillPolygon(Polygon p) {
        delegate.fillPolygon(p);
    }

    public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {
        delegate.fillPolygon(xPoints, yPoints, nPoints);
    }

    public void fillOval(int x, int y, int width, int height) {
        delegate.fillOval(x, y, width, height);
    }

    public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
        delegate.fillArc(x, y, width, height, startAngle, arcAngle);
    }

    public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
        delegate.drawRoundRect(x, y, width, height, arcWidth, arcHeight);
    }

    public void drawRect(int x, int y, int width, int height) {
        delegate.drawRect(x, y, width, height);
    }

    public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {
        delegate.drawPolyline(xPoints, yPoints, nPoints);
    }

    public void drawPolygon(Polygon p) {
        delegate.drawPolygon(p);
    }

    public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {
        delegate.drawPolygon(xPoints, yPoints, nPoints);
    }

    public void drawOval(int x, int y, int width, int height) {
        delegate.drawOval(x, y, width, height);
    }

    public void drawLine(int x1, int y1, int x2, int y2) {
        delegate.drawLine(x1, y1, x2, y2);
    }

    public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, Color bgcolor, ImageObserver observer) {
        return delegate.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, bgcolor, observer);
    }

    public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, ImageObserver observer) {
        return delegate.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, observer);
    }

    public boolean drawImage(Image img, int x, int y, int width, int height, Color bgcolor, ImageObserver observer) {
        return delegate.drawImage(img, x, y, width, height, bgcolor, observer);
    }

    public boolean drawImage(Image img, int x, int y, Color bgcolor, ImageObserver observer) {
        return delegate.drawImage(img, x, y, bgcolor, observer);
    }

    public boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer) {
        return delegate.drawImage(img, x, y, width, height, observer);
    }

    public boolean drawImage(Image img, int x, int y, ImageObserver observer) {
        return delegate.drawImage(img, x, y, observer);
    }

    public void drawChars(char[] data, int offset, int length, int x, int y) {
        delegate.drawChars(data, offset, length, x, y);
    }

    public void drawBytes(byte[] data, int offset, int length, int x, int y) {
        delegate.drawBytes(data, offset, length, x, y);
    }

    public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
        delegate.drawArc(x, y, width, height, startAngle, arcAngle);
    }

    public void dispose() {
        delegate.dispose();
    }

    public Graphics create(int x, int y, int width, int height) {
        return delegate.create(x, y, width, height);
    }

    public Graphics create() {
        return delegate.create();
    }

    public void copyArea(int x, int y, int width, int height, int dx, int dy) {
        delegate.copyArea(x, y, width, height, dx, dy);
    }

    public void clipRect(int x, int y, int width, int height) {
        //ignore
    }

    public void clearRect(int x, int y, int width, int height) {
        delegate.clearRect(x, y, width, height);
    }

    public void translate(double tx, double ty) {
        delegate.translate(tx, ty);
    }

    public void translate(int x, int y) {
        delegate.translate(x, y);
    }

    public void transform(AffineTransform Tx) {
        delegate.transform(Tx);
    }

    public void shear(double shx, double shy) {
        delegate.shear(shx, shy);
    }

    public void setTransform(AffineTransform Tx) {
        delegate.setTransform(Tx);
    }

    public void setStroke(Stroke s) {
        delegate.setStroke(s);
    }

    public void setRenderingHints(Map<?, ?> hints) {
        delegate.setRenderingHints(hints);
    }

    public void setRenderingHint(Key hintKey, Object hintValue) {
        delegate.setRenderingHint(hintKey, hintValue);
    }

    public void setPaint(Paint paint) {
        delegate.setPaint(paint);
    }

    public void setComposite(Composite comp) {
        delegate.setComposite(comp);
    }

    public void setBackground(Color color) {
        delegate.setBackground(color);
    }

    public void scale(double sx, double sy) {
        delegate.scale(sx, sy);
    }

    public void rotate(double theta, double x, double y) {
        delegate.rotate(theta, x, y);
    }

    public void rotate(double theta) {
        delegate.rotate(theta);
    }

    public boolean hit(Rectangle rect, Shape s, boolean onStroke) {
        return delegate.hit(rect, s, onStroke);
    }

    public AffineTransform getTransform() {
        return delegate.getTransform();
    }

    public Stroke getStroke() {
        return delegate.getStroke();
    }

    public RenderingHints getRenderingHints() {
        return delegate.getRenderingHints();
    }

    public Object getRenderingHint(Key hintKey) {
        return delegate.getRenderingHint(hintKey);
    }

    public Paint getPaint() {
        return delegate.getPaint();
    }

    public FontRenderContext getFontRenderContext() {
        return delegate.getFontRenderContext();
    }

    public GraphicsConfiguration getDeviceConfiguration() {
        return delegate.getDeviceConfiguration();
    }

    public Composite getComposite() {
        return delegate.getComposite();
    }

    public Color getBackground() {
        return delegate.getBackground();
    }

    public void fill3DRect(int x, int y, int width, int height, boolean raised) {
        delegate.fill3DRect(x, y, width, height, raised);
    }

    public void fill(Shape s) {
        delegate.fill(s);
    }

    public void drawString(AttributedCharacterIterator iterator, float x, float y) {
        delegate.drawString(iterator, x, y);
    }

    public void drawString(AttributedCharacterIterator iterator, int x, int y) {
        delegate.drawString(iterator, x, y);
    }

    public void drawString(String str, float x, float y) {
        delegate.drawString(str, x, y);
    }

    public void drawString(String str, int x, int y) {
        delegate.drawString(str, x, y);
    }

    public void drawRenderedImage(RenderedImage img, AffineTransform xform) {
        delegate.drawRenderedImage(img, xform);
    }

    public void drawRenderableImage(RenderableImage img, AffineTransform xform) {
        delegate.drawRenderableImage(img, xform);
    }

    public void drawImage(BufferedImage img, BufferedImageOp op, int x, int y) {
        delegate.drawImage(img, op, x, y);
    }

    public boolean drawImage(Image img, AffineTransform xform, ImageObserver obs) {
        return delegate.drawImage(img, xform, obs);
    }

    public void drawGlyphVector(GlyphVector g, float x, float y) {
        delegate.drawGlyphVector(g, x, y);
    }

    public void draw3DRect(int x, int y, int width, int height, boolean raised) {
        delegate.draw3DRect(x, y, width, height, raised);
    }

    public void draw(Shape s) {
        delegate.draw(s);
    }

    public void clip(Shape s) {
        //ignore
    }

    public void addRenderingHints(Map<?, ?> hints) {
        delegate.addRenderingHints(hints);
    }
}