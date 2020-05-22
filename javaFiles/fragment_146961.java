import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DrawingPanel extends JPanel {
    private Image img;
    private Rectangle rectangle;

    public DrawingPanel(Image img) {
        this.img = img;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null) {
            g.drawImage(img, 0, 0, this);
        }
        if (rectangle != null) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setXORMode(Color.WHITE);
            g2.draw(rectangle);
            g2.dispose(); // since we created this object
        }
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension superSize = super.getPreferredSize();
        if (img == null) {
            return super.getPreferredSize();
        } else {
            int w = img.getWidth(this);
            int h = img.getHeight(this);
            return new Dimension(w, h);
        }
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }
}