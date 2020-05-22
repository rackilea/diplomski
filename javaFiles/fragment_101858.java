import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.font.TextAttribute;
import java.math.*;
import java.text.*;
import java.util.Map;
import java.util.Vector;
import javax.swing.*;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;
import javax.swing.event.*;
import javax.swing.text.InternationalFormatter;

public class FormatterLimit {

    private JFrame frame = new JFrame("AbstractTextField Test");
    private Map attributes = (new Font("Serif", Font.BOLD, 16)).getAttributes();
    private JFormattedTextField textField1 = new JFormattedTextField(new Float(710.01));
    private JFormattedTextField textField2 = new JFormattedTextField(new Float(150.01));
    private Vector<Boolean> comboBoxItems = new Vector<Boolean>();
    private JComboBox box = new JComboBox(comboBoxItems);
    private JButton btn = new JButton("Validations !!!");
    private Boolean isValidFromTextField1 = true;
    private Boolean isValidFromTextField2 = true;
    private Boolean isValidFromBox = true;
    private javax.swing.Timer timer = null;

    public FormatterLimit() {
        attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
        textField1.setFormatterFactory(new AbstractFormatterFactory() {
            @Override
            public AbstractFormatter getFormatter(JFormattedTextField tf) {
                NumberFormat format = DecimalFormat.getInstance();
                format.setMinimumFractionDigits(2);
                format.setMaximumFractionDigits(2);
                format.setRoundingMode(RoundingMode.HALF_UP);
                InternationalFormatter formatter = new InternationalFormatter(format);
                formatter.setAllowsInvalid(false);
                formatter.setMinimum(0.0);
                formatter.setMaximum(1000.00);
                return formatter;
            }
        });
        textField1.getDocument().addDocumentListener(new DocumentListener() {
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
                double t1a1 = (((Number) textField1.getValue()).doubleValue());
                if (t1a1 < 500) {
                    Runnable doRun = new Runnable() {
                        @Override
                        public void run() {
                            isValidFromTextField1 = false;
                            validFormatterLimit();
                            textField1.setFont(new Font(attributes));
                            textField1.setForeground(Color.red);
                        }
                    };
                    SwingUtilities.invokeLater(doRun);
                } else {
                    Runnable doRun = new Runnable() {
                        @Override
                        public void run() {
                            isValidFromTextField1 = true;
                            validFormatterLimit();
                            textField1.setFont(new Font("Serif", Font.BOLD, 16));
                            textField1.setForeground(Color.black);
                        }
                    };
                    SwingUtilities.invokeLater(doRun);
                }
            }
        });
        textField2.setFormatterFactory(new AbstractFormatterFactory() {
            @Override
            public AbstractFormatter getFormatter(JFormattedTextField tf) {
                NumberFormat format = DecimalFormat.getInstance();
                format.setMinimumFractionDigits(2);
                format.setMaximumFractionDigits(2);
                format.setRoundingMode(RoundingMode.HALF_UP);
                InternationalFormatter formatter = new InternationalFormatter(format);
                formatter.setAllowsInvalid(false);
                //formatter.setMinimum(0.0);
                //formatter.setMaximum(1000.00);
                return formatter;
            }
        });
        textField2.getDocument().addDocumentListener(new DocumentListener() {
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
                double t1a1 = (((Number) textField2.getValue()).doubleValue());
                if (t1a1 > 1000) {
                    Runnable doRun = new Runnable() {
                        @Override
                        public void run() {
                            isValidFromTextField2 = false;
                            validFormatterLimit();
                            textField2.setFont(new Font(attributes));
                            textField2.setForeground(Color.red);
                        }
                    };
                    SwingUtilities.invokeLater(doRun);
                } else {
                    Runnable doRun = new Runnable() {
                        @Override
                        public void run() {
                            isValidFromTextField2 = true;
                            validFormatterLimit();
                            textField2.setFont(new Font("Serif", Font.BOLD, 16));
                            textField2.setForeground(Color.black);
                        }
                    };
                    SwingUtilities.invokeLater(doRun);
                }
            }
        });
        comboBoxItems.add(Boolean.TRUE);
        comboBoxItems.add(Boolean.FALSE);
        box = new JComboBox(comboBoxItems);
        box.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (e.getSource() == box) {
                        if (box.getSelectedItem() == (Boolean) true) {
                            isValidFromBox = true;
                            validFormatterLimit();
                        } else {
                            isValidFromBox = false;
                            validFormatterLimit();
                        }
                    }
                }
            }
        });
        frame.setLayout(new GridLayout(5, 0, 5, 5));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(textField1);
        frame.add(textField2);
        frame.add(box, BorderLayout.SOUTH);
        frame.add(new JLabel());
        frame.add(btn);
        frame.setVisible(true);
        frame.pack();
        start();
    }

    private void start() {
        timer = new javax.swing.Timer(3500, updateCol());
        timer.setRepeats(false);
        timer.start();
    }

    public Action updateCol() {
        return new AbstractAction("text load action") {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setValue(300);
                textField2.setValue(8000);
                if (box.getSelectedItem() == (Boolean) false) {
                    box.setSelectedItem((Boolean) true);
                } else {
                    box.setSelectedItem((Boolean) false);
                }
            }
        };
    }

    public void validFormatterLimit(/*Boolean isValidFromTextField1, 
             * Boolean isValidFromTextField2 , Boolean isValidFromBox*/) {
        if (isValidFromTextField1) {
            if (isValidFromTextField2) {
                if (isValidFromBox) {
                    btn.setEnabled(true);
                } else {
                    btn.setEnabled(false);
                }
            } else {
                btn.setEnabled(false);
            }
        } else {
            btn.setEnabled(false);
        }
    }


    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                FormatterLimit comboBoxModel = new FormatterLimit();
            }
        });
    }
}