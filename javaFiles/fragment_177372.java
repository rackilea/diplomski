import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class testOptionPane extends JFrame implements ActionListener, FocusListener {

    public ArrayList<JTextField> fields = new ArrayList<>();
    public JPanel panel = new JPanel();
    public JTextField f = new JTextField(12);
    private int currentField = 0;
    private boolean focusReturned = false;
    public static void main(String[] args) {
        new testOptionPane();
    }

    public testOptionPane() {
        for (int i = 0; i < 4; i++) {
            JTextField tf = new JTextField(12);
            fields.add(tf);
            tf.addFocusListener(this);
            panel.add(tf);
        }
        add(panel);
        fields.add(f);
        add(f);
        setTitle("Hello World");
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(920, 420);
        setLocation(100, 100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    }

    @Override
    public void focusGained(FocusEvent fe) {
        if (fe.getSource() == fields.get(currentField)) {
            if (!focusReturned) {
                JOptionPane.showMessageDialog(this, "focus on field " + String.valueOf(currentField));
                System.out.println(currentField);
                focusReturned = true;
            } else {
                currentField++;
                focusReturned = false;
                if (currentField < fields.size()) {
                    fields.get(currentField).requestFocus();
                }
            }
        }
    }

    @Override
    public void focusLost(FocusEvent fe) {
    }
}