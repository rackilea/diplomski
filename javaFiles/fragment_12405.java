import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/** @see http://stackoverflow.com/q/10067399/230513 */
public class NewJavaGUI extends JPanel {

    public NewJavaGUI() {
        Class1 class1 = new Class1();
        Class2 class2 = new Class2(class1);
        this.add(class1.textField);
        this.add(new JLabel(class2.s));
    }

    private static class Class1 extends Object {

        private final JTextField textField = new JTextField("Something");

        public Class1() {} // implicit

        public String getTextFieldString() {
            return textField.getText();
        }
    }

    private static class Class2 extends Object {

        private final Class1 c1;
        private final String s;

        public Class2(Class1 class1) {
            c1 = class1;
            s = c1.getTextFieldString();
        }
    }

    private void display() {
        JFrame f = new JFrame("NewJavaGUI");
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
                new NewJavaGUI().display();
            }
        });
    }
}