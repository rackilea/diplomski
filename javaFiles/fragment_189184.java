import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Curve extends JFrame {

    public static void main(String[] args) {
        final JFrame f = new JFrame("My curve");
        f.setSize(600, 400);

        f.add(new JComponent() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D graphics = (Graphics2D) g.create();// your graphics object
                double[] x = {50, 100, 300, 500}; // x coordinates of polyline
                double[] y = {70, 120, 50, 280}; // y coordinates of polyline
                Path2D polyline = new Path2D.Double();
                polyline.moveTo(x[0], y[0]);
                for (int i = 1; i < x.length; i++) {
                    polyline.lineTo(x[i], y[i]);
                }
                graphics.draw(polyline);
                graphics.dispose();
            }
        });
        f.setVisible(true);

    }
}