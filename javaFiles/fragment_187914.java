import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;

/** @see http://stackoverflow.com/questions/4656395 */
public class CursorTest extends JPanel {

    public CursorTest() {
        this.setPreferredSize(new Dimension(640, 480));
    }

    private void display() {
        JFrame f = new JFrame("CursorTest");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(this);
        f.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new CursorTest().display();
            }
        });
    }
}