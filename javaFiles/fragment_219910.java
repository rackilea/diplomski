import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;


public class MoreAndMoreTextfields extends JFrame {

    // the panel, that we will add the visible fields to
    private JPanel panel = new JPanel();

    // a collection of all fields, so that we can access them afterwards
    private Collection<JTextField> textFields = new ArrayList<JTextField>();

    public MoreAndMoreTextfields() {

        // basic window layout stuff
        setSize(400, 300);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        setContentPane(panel);

        // add label, that will create new input fields
        JLabel addInputLabel = new JLabel("click for more fields");
        addInputLabel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                JTextField textField = new JTextField();
                panel.add(textField);
                textField.setPreferredSize(new Dimension(100,20));
                textFields.add(textField);
                revalidate();
            }
        });
        panel.add(addInputLabel);

        // add new label, that will print out contents
        JLabel outputLabel = new JLabel("click for contents");
        outputLabel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Contents of fields:");
                for (JTextField textField : textFields) {
                    System.out.println("  input:"+textField.getText());
                }
            }
        });
        panel.add(outputLabel);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new MoreAndMoreTextfields().setVisible(true);
            }
        });
    }
}