import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author David
 */
public class Test extends JFrame {

    private JTextField textField, textField2;

    public Test() {
        createAndShowUI();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                Test test = new Test();
            }
        });
    }

    private void createAndShowUI() {
        setTitle("Test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createComponents();
        addComponentsToContentPane();
        addListeners();

        pack();
        setVisible(true);
    }

    private void addComponentsToContentPane() {
        getContentPane().setLayout(new GridLayout(2, 1));

        getContentPane().add(textField);
        getContentPane().add(textField2);
    }

    private void createComponents() {
        textField = new JTextField(10);
        textField2 = new JTextField("Click here to lose focus of above textField");
    }

    private void addListeners() {
        textField.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent fe) {
            }

            @Override
            public void focusLost(FocusEvent fe) {
                if (textField.getText().length() >=1) {
                    JOptionPane.showMessageDialog(null, "You entered valid data");
                    textField.setText("");
                }else {
                    JOptionPane.showMessageDialog(null, "You entered invalid data");
                    textField.grabFocus();//make the textField in foucs again
                }
            }
        });
    }
}