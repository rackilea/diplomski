import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Map;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;

public class TextAttributeSTRIKETHROUGH {

    private JFrame frame = new JFrame();
    private JPanel pnl = new JPanel();
    private JLabel focusLabel = new JLabel(" focusLost Handle ");
    private JFormattedTextField formTextField;
    private JLabel docLabel = new JLabel(" document Handle ");
    private JFormattedTextField formTextField1;
    private NumberFormat formTextFieldFormat;
    private double amount = 10000.00;
    private Map attributes;

    @SuppressWarnings("unchecked")
    public TextAttributeSTRIKETHROUGH() {
        formTextFieldFormat = NumberFormat.getNumberInstance();
        formTextFieldFormat.setMinimumFractionDigits(2);
        formTextFieldFormat.setMaximumFractionDigits(2);
        formTextFieldFormat.setRoundingMode(RoundingMode.HALF_UP);

        focusLabel.setFont(new Font("Serif", Font.BOLD, 14));
        focusLabel.setForeground(Color.blue);
        focusLabel.setPreferredSize(new Dimension(120, 27));
        formTextField = new JFormattedTextField(formTextFieldFormat);
        formTextField.setValue(amount);
        formTextField.setFont(new Font("Serif", Font.BOLD, 22));
        formTextField.setForeground(Color.black);
        formTextField.setBackground(Color.yellow);
        formTextField.setPreferredSize(new Dimension(120, 27));
        formTextField.setHorizontalAlignment(SwingConstants.RIGHT);
        formTextField.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                formTextField.requestFocus();
                formTextField.setText(formTextField.getText());
                formTextField.selectAll();
            }

            public void focusLost(FocusEvent e) {
                //Runnable doRun = new Runnable() {

                //@Override
                //public void run() {
                double t1a1 = (((Number) formTextField.getValue()).doubleValue());
                if (t1a1 < 1000) {
                    formTextField.setValue(amount);
                }
                //}
                // };
                //SwingUtilities.invokeLater(doRun);
            }
        });

        docLabel.setFont(new Font("Serif", Font.BOLD, 14));
        docLabel.setForeground(Color.blue);
        docLabel.setPreferredSize(new Dimension(120, 27));

        formTextField1 = new JFormattedTextField(formTextFieldFormat);
        formTextField1.setValue(amount);
        formTextField1.setFont(new Font("Serif", Font.BOLD, 22));
        formTextField1.setForeground(Color.black);
        formTextField1.setBackground(Color.yellow);
        formTextField1.setPreferredSize(new Dimension(120, 27));
        formTextField1.setHorizontalAlignment(SwingConstants.RIGHT);
        formTextField1.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                formTextField1.requestFocus();
                formTextField1.setText(formTextField1.getText());
                formTextField1.selectAll();
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        });
        formTextField1.getDocument().addDocumentListener(docListener);

        attributes = (new Font("Serif", Font.BOLD, 24)).getAttributes();
        attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);

        pnl = new JPanel();
        pnl.setBorder(new EmptyBorder(2, 2, 2, 2));
        pnl.setLayout(new GridLayout(2, 2));
        pnl.add(focusLabel);
        pnl.add(formTextField);
        pnl.add(docLabel);
        pnl.add(formTextField1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(pnl, BorderLayout.CENTER);
        frame.setLocation(200, 200);
        frame.pack();
        frame.setVisible(true);
        formTextFieldFocus1();
    }
    //
    private DocumentListener docListener = new DocumentListener() {

        @Override
        public void changedUpdate(DocumentEvent documentEvent) {
            printIt(documentEvent);
        }

        @Override
        public void insertUpdate(DocumentEvent documentEvent) {
            printIt(documentEvent);
        }

        @Override
        public void removeUpdate(DocumentEvent documentEvent) {
            printIt(documentEvent);
        }

        private void printIt(DocumentEvent documentEvent) {
            DocumentEvent.EventType type = documentEvent.getType();
            double t1a1 = (((Number) formTextField1.getValue()).doubleValue());
            if (t1a1 < 1000) {
                Runnable doRun = new Runnable() {

                    @Override
                    public void run() {
                        formTextField1.setFont(new Font(attributes));
                    }
                };
                SwingUtilities.invokeLater(doRun);
            } else {
                Runnable doRun = new Runnable() {

                    @Override
                    public void run() {
                        formTextField1.setFont(new Font("Serif", Font.BOLD, 22));
                    }
                };
                SwingUtilities.invokeLater(doRun);
            }
        }
    };

    private void formTextFieldFocus1() {
        Runnable doRun = new Runnable() {

            @Override
            public void run() {
                formTextField1.grabFocus();
                formTextField1.requestFocus();
                formTextField1.setText(formTextField1.getText());
                formTextField1.selectAll();
            }
        };
        SwingUtilities.invokeLater(doRun);
    }

    private void formTextFieldFocus() {
        Runnable doRun = new Runnable() {

            @Override
            public void run() {
                formTextField.grabFocus();
                formTextField.requestFocus();
                formTextField.setText(formTextField.getText());
                formTextField.selectAll();
                formTextFieldFocus1();
            }
        };
        SwingUtilities.invokeLater(doRun);
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                TextAttributeSTRIKETHROUGH fl = new TextAttributeSTRIKETHROUGH();
            }
        });
    }
}