import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/** @see http://stackoverflow.com/questions/5421319 */
public class TextAreaTest extends JPanel {

    private static final int maxWidth = 900;
    private static final int maxHeight = 600;
    private static final int initXPos = 320;
    private static final int initYPos = 260;
    private JTextArea ta = new JTextArea();

    public TextAreaTest() {
        this.setPreferredSize(new Dimension(900, 600));
        this.setLayout(new GridLayout());
        this.add(ta);
        ta.append("Hello, world!");
    }

    private void display() {
        JFrame f = new JFrame("TextAreaTest");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(this);
        f.pack();
        f.setLocation(initXPos, initYPos);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TextAreaTest().display();
            }
        });
    }
}