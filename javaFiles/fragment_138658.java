import javax.swing.*;
import java.awt.geom.*;
import java.awt.Graphics;
import java.util.*;

public class Scatterplot extends JFrame {

    private List points = new ArrayList();

    public Scatterplot() {
        super("Scatterplot");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        points.add(new Point2D.Float(2, 4));
        points.add(new Point2D.Float(16, 15));
        points.add(new Point2D.Float(20, 14));
        points.add(new Point2D.Float(62, 24));
        points.add(new Point2D.Float(39, 84));

        JPanel panel = new JPanel() { 
            public void paintComponent(Graphics g) {
                for(Iterator i=points.iterator(); i.hasNext(); ) {
                    Point2D.Float pt = (Point2D.Float)i.next();
                    g.drawString("X", (int)pt.x, (int)pt.y);
                }
            }
        };

        setContentPane(panel);
        setBounds(20, 20, 200, 200);
        setVisible(true);       
    }
    public static void main(String[] args) {
        new Scatterplot();
    }
}