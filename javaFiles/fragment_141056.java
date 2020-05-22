import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ToolTipManager;

/**
 * @see https://stackoverflow.com/a/53609066/230513
 * @see https://stackoverflow.com/a/25944439/230513
 */
public class ShapeToolTip {

    private static class ShapePanel extends JPanel {

        private final List<Shape> list = new ArrayList<>();

        public ShapePanel() {
            Polygon p = new Polygon();
            p.addPoint(500, 100);
            p.addPoint(500, 400);
            p.addPoint(200, 400);
            list.add(p);
            list.add(new Ellipse2D.Double(100, 100, 200, 200));
            ToolTipManager.sharedInstance().registerComponent(this);
        }

        @Override
        public String getToolTipText(MouseEvent e) {
            for (Shape shape : list) {
                if (shape.contains(e.getX(), e.getY())) {
                    return shape.getClass().getName();
                }
            }
            return "Outside";
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.blue);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setStroke(new BasicStroke(2));
            for (Shape shape : list) {
                g2d.draw(shape);
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(640, 480);
        }
    }

    private void display() {
        JFrame f = new JFrame("ShapeToolTip");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new ShapePanel());
        JLabel title = new JLabel("Shape Tool Tip", JLabel.CENTER);
        title.setToolTipText("Title");
        title.setFont(title.getFont().deriveFont(Font.BOLD, 24));
        f.add(title, BorderLayout.SOUTH);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new ShapeToolTip()::display);
    }
}