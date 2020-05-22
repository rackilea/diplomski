import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
// and other stuffes you should have already imported

@Override
public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Area area = new Area(
            new RoundRectangle2D.Double(0, 0, 200, 200, 50, 50));
    area.subtract(new Area(new Ellipse2D.Double(75, 50, 50, 50)));
    g.setColor(Color.RED);
    ((Graphics2D) g).fill(area);
}