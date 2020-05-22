import javax.swing.*;
import java.awt.geom.*;
import java.awt.*;
public class PaintComponent extends JPanel
{
    public PaintComponent()
    {
        setPreferredSize(new Dimension(400,400));
    }
    public void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D)g;
        g2d.draw(new Arc2D.Double(100,100,100,100,0,30,Arc2D.PIE));
        g2d.fill(new Arc2D.Double(100,100,100,100,30,330,Arc2D.PIE));
    }
}