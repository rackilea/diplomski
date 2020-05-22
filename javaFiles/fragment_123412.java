import java.awt.*;
import javax.swing.*;

public class InactiveBackgroundTest {

    public JComponent makeUI() {
        JTextField s0 = new JTextField("Very long Text");
        s0.setEnabled(true);
        s0.setForeground(Color.yellow);
        s0.setBackground(Color.blue);
        //UIManager.put("FormattedTextField.inactiveBackground", Color.RED);

        JTextField s1 = new JTextField("Very long Text");
        s1.setEnabled(false);
        s1.setForeground(Color.yellow);
        s1.setBackground(Color.blue);
        s1.setDisabledTextColor(Color.yellow);

        JTextField s2 = new JTextField("Very long Text");
        s2.setEditable(false);
        s2.setForeground(Color.yellow);
        s2.setBackground(Color.blue);
        s2.setDisabledTextColor(Color.yellow);

        JPanel p = new JPanel();
        p.setBackground(Color.black);
        p.add(s0);
        p.add(s1);
        p.add(s2);
        return p;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public static void createAndShowGUI() {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.getContentPane().add(new InactiveBackgroundTest().makeUI());
        f.setLocationRelativeTo(null);
        f.pack();
        f.setVisible(true);
    }
}