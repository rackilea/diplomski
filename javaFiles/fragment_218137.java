import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Test {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Test gui = new Test();
            }
        });
    }

    public Test() {
        initComponents();
    }

    private void initComponents() {
        JFrame frame = new JFrame("Line Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new MyPanel());

        frame.pack();
        frame.setVisible(true);
    }
}

class MyPanel extends JPanel {

    Point point1;
    Point point2;
    Line2D line2d;

    public MyPanel() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                super.mousePressed(me);
                point1 = me.getPoint();
            }
        });
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                super.mouseDragged(me);
                point2 = me.getPoint();
                line2d = new Line2D.Double(point1, point2);
                repaint();
            }
        });
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        //Set  anti-alias!
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        if (point1 != null && point2 != null) {
            g2d.setPaint(Color.RED);
            g2d.setStroke(new BasicStroke(1.5f));//set stroke size
            g2d.draw(line2d);
        }
    }
}