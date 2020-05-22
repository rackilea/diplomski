package explodingimage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.beans.Transient;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel {
private Terrain terrain;

public GamePanel() {
    this.terrain = new Terrain();
}

@Override
@Transient
public Dimension getPreferredSize() {
    return terrain.getBounds();
}

@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g.create();

    // Draw background image of terrain
    g2d.drawImage(terrain.getImage(), terrain.getImageX(),
            terrain.getImageY(), null);

    // Draw the rectangular object
    Rectangle r = terrain.getFallingRectangle().getRectangle();
    g2d.setColor(Color.black);
    g2d.drawString(r.x + "," + r.y, r.x, r.y);
    g2d.draw(r);
    g2d.setColor(terrain.getFallingRectangle().getColor());
    g2d.fill(r);
}

public Terrain getTerrain() {
    return terrain;
}
 }