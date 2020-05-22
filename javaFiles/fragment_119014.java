import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.text.MaskFormatter;

public class FormattedTextFieldExample {

    public FormattedTextFieldExample() {
        initComponents();
    }

    private void initComponents() {
        JFrame frame = new JFrame("JFormattedTextField Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MaskFormatter mask = null;
        try {
            mask = new MaskFormatter("##h##min##s");//the # is for numeric values
            mask.setPlaceholderCharacter('#');
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //
        // Create a formatted text field that accept a valid time.
        //
        final JFormattedTextField timeField = new JFormattedTextField(mask);

        //Add ActionListener for when enter is pressed
        timeField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Object source = ae.getSource();
                if (source == timeField) {
                    //parse to a valid time here
                    System.out.println(timeField.getText());
                }
            }
        });

        frame.add(timeField);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FormattedTextFieldExample();
            }
        });
    }
}