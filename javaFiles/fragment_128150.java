import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

/** @see http://stackoverflow.com/questions/3951383 */
public class JDPTest extends JDesktopPane {

    private static final Stroke s = new BasicStroke(4.0f);
    private MyFrame one = new MyFrame("One", 100, 100);
    private MyFrame two = new MyFrame("Two", 400, 240);

    public JDPTest() {
        this.setPreferredSize(new Dimension(640, 480));
        this.add(one);
        this.add(two);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.lightGray);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.setColor(Color.blue);
        g2d.setStroke(s);
        int x1 = one.getX() + one.getWidth() / 2;
        int y1 = one.getY() + one.getHeight() / 2;
        int x2 = two.getX() + two.getWidth() / 2;
        int y2 = two.getY() + two.getHeight() / 2;
        g2d.drawLine(x1, y1, x2, y2);
    }

    private final class MyFrame extends JInternalFrame {

        MyFrame(String name, int x, int y) {
            super(name);
            this.setSize(160, 100);
            this.setLocation(x, y);
            this.setVisible(true);
            this.addComponentListener(new ComponentAdapter() {

                @Override
                public void componentMoved(ComponentEvent e) {
                    JDPTest.this.repaint();
                }
            });
        }
    }

    private void display() {
        JFrame f = new JFrame("JDPTest");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(this);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new JDPTest().display();
            }
        });
    }
}