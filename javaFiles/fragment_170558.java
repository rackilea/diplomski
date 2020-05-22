import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * @see https://stackoverflow.com/a/41085019/230513
 */
public class GridTest {

    private static final int N = 12;

    private void display() {
        JFrame f = new JFrame("GridTest");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(3, 4));
        for (int i = 0; i < N; i++) {
            panel.add(createPanel(i));
        }
        f.add(new JScrollPane(panel));
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private static JPanel createPanel(int i) {
        JPanel panel = new JPanel(new GridLayout(2, 2, 8, 8));
        panel.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.add(new JLabel(String.valueOf(i)));
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JTextField(String.valueOf(Character.valueOf((char) ('A' + i)))));
        return panel;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new GridTest()::display);
    }
}