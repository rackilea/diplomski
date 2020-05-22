import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Path2D;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class Test {
@SuppressWarnings("serial")
public static void main(String[] args) {
    JFrame f = new JFrame("Test");
    JPanel c = new JPanel() {
        Area a;
        Path2D p;
        {
            p = new Path2D.Double();
            p.append(new CubicCurve2D.Double(0, 0, 100, 0, 150, 50, 200, 100), true);
            p.append(new CubicCurve2D.Double(200, 100, 200, 150, 150,0, 50, 100), true);
            p.append(new CubicCurve2D.Double(100, 100, 100, 50, 50, 50, 0, 0), true);
            a = new Area(p);
            setPreferredSize(new Dimension(300, 300));
        }
        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(Color.black);
            ((Graphics2D)g).fill(p);
            System.out.println(a.isSingular());
        }
    };
    f.setContentPane(c);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.pack();
    f.setVisible(true);
}
}