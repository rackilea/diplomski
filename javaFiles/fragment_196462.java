import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test2 extends JPanel {

    private static final long serialVersionUID = 1L;
    private JButton a = new JButton("A");

    public Test2() {
        setFocusable(true);
        setLayout(new GridLayout(3, 3));
        a.setEnabled(false);
        add(a);
        addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    remove(a);
                    JButton b = new JButton("B");
                    add(b);
                    add(a);
                    revalidate();
                    repaint();
                }
            }
        });
    }

    public static void main(String... args) {
        JFrame frame = new JFrame("");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Test2());
        frame.pack();
        frame.setVisible(true);
    }
}