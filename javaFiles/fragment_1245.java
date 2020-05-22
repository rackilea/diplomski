import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.Box;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

public class InputVerifyDate {

    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    public InputVerifyDate() {
        JFormattedTextField formattedField = createFormattedTextField();
        JTextField field = new JTextField(10);
        format.setLenient(false);

        Box box = Box.createVerticalBox();
        box.add(formattedField);
        box.add(Box.createVerticalStrut(10));
        box.add(field);
        box.setBorder(new EmptyBorder(10, 10, 10, 10));

        JFrame frame = new JFrame();
        frame.add(box);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JFormattedTextField createFormattedTextField() {
        JFormattedTextField formattedField = null;
        try {
            MaskFormatter dateMask = new MaskFormatter("##/##/####");
            formattedField = new JFormattedTextField(dateMask);
        } catch (ParseException ex) {
            Logger.getLogger(InputVerifyDate.class.getName()).log(Level.SEVERE, null, ex);
        }
        formattedField.setColumns(10);
        formattedField.setInputVerifier(getInputVerifier());
        return formattedField;
    }

    private InputVerifier getInputVerifier() {
        InputVerifier verifier = new InputVerifier() {

            @Override
            public boolean verify(JComponent input) {
                JFormattedTextField field = (JFormattedTextField) input;
                String text = field.getText();
                return isValidDate(text);
            }

            @Override
            public boolean shouldYieldFocus(JComponent input) {
                boolean valid = verify(input);
                if (!valid) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid date in format dd/mm/yyyy");
                }
                return valid;
            }

        };
        return verifier;
    }

    public boolean isValidDate(String dateString) {
        try {
            format.parse(dateString);
            return true;
        } catch (ParseException ex) {
            return false;

        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new InputVerifyDate();
            }
        });

    }
}