import java.awt.*;
import java.awt.geom.Path2D;

import javax.swing.*;

public class FrameTestBase extends JFrame {

    public static void main(String args[]) {
        FrameTestBase t = new FrameTestBase();
        t.add(new JComponent() {
            public void paintComponent(Graphics g) {
                Path2D p = new Path2D.Double();
                p.moveTo(15, 15);
                p.lineTo(150, 75);
                p.lineTo(100, 10);
                p.lineTo(10, 100);

                ((Graphics2D) g).draw(p);
            }
        });

        t.setDefaultCloseOperation(EXIT_ON_CLOSE);
        t.setSize(200, 200);
        t.setVisible(true);
    }
}