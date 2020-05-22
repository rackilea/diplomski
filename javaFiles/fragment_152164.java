import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * @see https://stackoverflow.com/a/15078211/230513
 */
public class Test {

    JTextField field1 = new JTextField();
    JTextField field2 = new JTextField();
    JTextField field3 = new JTextField();
    JTextField field4 = new JTextField();
    JTextField field5 = new JTextField();
    JTextField field6 = new JTextField();
    JTextField field7 = new JTextField();
    JTextField field8 = new JTextField();
    JTextField field9 = new JTextField();
    JTextField field10 = new JTextField();
    JTextField field11 = new JTextField();
    JTextField field12 = new JTextField();
    JTextField field13 = new JTextField();
    JTextField field14 = new JTextField();
    JTextField field15 = new JTextField();
    JTextField field16 = new JTextField();
    JTextField field17 = new JTextField();
    JTextField field18 = new JTextField();
    Object[] message = {
        "Rent:", field1,
        "Water:", field2,
        "Light:", field3,
        "DTV:", field4,
        "Sprint:", field5,
        "stf:", field6,
        "Tithe:", field7,
        "sff:", field8,
        "trr:", field9,
        "Citi:", field10,
        "Chase:", field11,
        "Walmart:", field12,
        "Miss:", field13,
        "Charter", field14,
        "Insurance:", field15,
        "Contribution", field16,
        "Lowes", field17,
        "Stream", field18,};

    private void display() {
        JPanel panel = new JPanel(new GridLayout(0, 2));
        int i = 0;
        while (i < message.length) {
            panel.add(new JLabel((String) message[i++], JLabel.RIGHT));
            panel.add((Component) message[i++]);
        }
        JScrollPane jsp = new JScrollPane(panel) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(320, 240);
            }
        };
        JOptionPane.showMessageDialog(
            null, jsp, "Enter data", JOptionPane.PLAIN_MESSAGE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Test().display();
            }
        });
    }
}