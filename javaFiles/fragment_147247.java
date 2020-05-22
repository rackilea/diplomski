import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @see http://stackoverflow.com/a/37366846/230513
 */
public class Test {

    private static final int PAD = 50;

    private void display() {
        JFrame f = new JFrame("Test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel p = new JPanel(new GridLayout(0, 1, PAD, PAD));
        p.setBorder(BorderFactory.createEmptyBorder(PAD, PAD, PAD, PAD));
        p.add(new JButton("Test Button 1"));
        p.add(new JButton("Test Button 2"));
        f.add(p, BorderLayout.CENTER);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Test()::display);
    }
}