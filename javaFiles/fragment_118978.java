import java.awt.*;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

/** @see http://stackoverflow.com/a/45055215/230513 */
public class JDPTest extends JDesktopPane {

    private MyFrame one = new MyFrame("One", 100, 100);

    public JDPTest() {
        this.setPreferredSize(new Dimension(640, 480));
        this.add(one);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.lightGray);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        print(g2d, 3, "Hello, world!");
        print(g2d, 2, "This is a test.");
        print(g2d, 1, "This is another test.");
        print(g2d, 0, "This is still another test.");
    }

    private void print(Graphics2D g2d, int line, String s) {
        FontMetrics fm = g2d.getFontMetrics();
        int x = this.getWidth() - fm.stringWidth(s) - 5;
        int y = this.getHeight() - fm.getDescent()
            - line * (fm.getHeight() + fm.getLeading());
        g2d.drawString(s, x, y);
    }

    private final class MyFrame extends JInternalFrame {

        MyFrame(String name, int x, int y) {
            super(name, true, true, true, true);
            this.setSize(320, 240);
            this.setLocation(x, y);
            this.setVisible(true);
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