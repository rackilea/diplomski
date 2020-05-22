import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test extends JPanel {

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x1 = 0;
        int y1 = 0;
        int x2 = 100;
        int y2 = 0;

        for (int i = 0; i < x2; i++) {
            g.drawLine(x1, y1, x2, y2);
            x1 += 1;
            y1 += 1;
            y2 += 1;
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(100, 100);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new Test());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}