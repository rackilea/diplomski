import javax.swing.JFrame;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;

public class Main extends JFrame {
    private static final long serialVersionUID = 1L;

    public Main() {
        getContentPane().setLayout(new MigLayout("", "[grow 30][grow 70]", "[]"));
        JLabel label = new JLabel("30%");
        getContentPane().add(label, "cell 0 0");
        JTextField textField = new JTextField("70%");
        getContentPane().add(textField, "cell 1 0,growx");
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}