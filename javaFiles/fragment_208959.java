import javax.swing.*;

public class FrameTestBase extends JFrame {

    public static void main(String args[]) {
        FrameTestBase t = new FrameTestBase();
        t.add(new JComponent() {
            public void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                    RenderingHints.VALUE_ANTIALIAS_ON);
                for (int i = 0; i < 50; i++) {
                    double delta = i / 10.0;
                    double y = 5 + 5*i;
                    Shape l = new Line2D.Double(5, y, 200, y + delta);
                    g2.draw(l);
                }
            }
        });

        t.setDefaultCloseOperation(EXIT_ON_CLOSE);
        t.setSize(400, 400);
        t.setVisible(true);
    }
}