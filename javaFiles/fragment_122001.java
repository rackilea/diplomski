import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;

class SnowmanShape implements MoveableShape {
    static final Color headColor = new Color(0xFFE9C9);
    static final Color bodyColor = new Color(0xEAF6FF);
    static final Color outlineColor = new Color(0x252525);

    int x;
    int y;
    int size;
    Ellipse2D.Double head;
    Ellipse2D.Double body;

    SnowmanShape(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
        initModel();
    }

    void initModel() {
        head = new Ellipse2D.Double(0, 0, size, size);
        body = new Ellipse2D.Double(0, head.height, size * 1.3d, size * 1.5d);
        body.x -= (body.width - head.width) * (1 / 2d);
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2.translate(x, y);
        g2.setColor(headColor);
        g2.fill(head);
        g2.setColor(outlineColor);
        g2.draw(head);
        g2.setColor(bodyColor);
        g2.fill(body);
        g2.setColor(outlineColor);
        g2.draw(body);
    }

    @Override
    public void translate(int dx, int dy) {
        x += dx;
        y += dy;
    }
}