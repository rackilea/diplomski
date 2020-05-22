import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.Dimension;

public class Stretch extends JFrame {
    int originalHeight = 600;
    int originalWidth = 600;
    public Stretch() {
        super("Stretch");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(originalWidth, originalHeight);
    }
    public static void main(String[] args) {
        Stretch s = new Stretch();
        s.setVisible(true);
    }
    public void paint(Graphics g) {
        Dimension size = this.getBounds().getSize();
        int rectWidth = 100;
        int rectHeight = 130;

        g.setColor(Color.white);
        g.fillRect(0, 0, size.width, size.height);

        g.setColor(Color.black);

        int w = rectWidth + size.width - originalWidth;
        int h = rectHeight + size.height - originalHeight;
        double sx = (double)w / rectWidth;
        double sy = (double)h / rectHeight;
        double s = Math.min(sx, sy);
        int fw = (int)(s * rectWidth);
        int fh = (int)(s * rectHeight);
        g.drawRect(100, 100, fw, fh);

    }
}