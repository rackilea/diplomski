import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;

/**
 * <code>Sh</code>.
 *
 * @author SMedvynskyy
 */
public class Sh extends JFrame
{
    public Sh()
    {
        super("SH");
        final JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.NORTH);

        final JTextField field = new JTextField(10);
        panel.add(field);

        final JTextField field1 = new JTextField(10);
        panel.add(field1);

        final DocumentListener docListener = new DocumentListener(){

            private Document originator;

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateLabel(e);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                updateLabel(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateLabel(e);
            }

            private void updateLabel(DocumentEvent e) {
                if (null == originator) {
                    originator = e.getDocument();
                    String text = "";
                    try {
                        text = originator.getText(0, originator.getLength());
                    } catch (final Exception ex) {
                        ex.printStackTrace();
                    }

                    if (!text.isEmpty()) {
                        final int p = Integer.parseInt(text);
                        if (originator.equals(field.getDocument())) {
                            final int i = (p + 1);
                            final String s = String.valueOf(i);
                            field1.setText(s);
                        } else {
                            final int i = (p - 1);
                            final String s = String.valueOf(i);
                            field.setText(s);
                        }
                    } else {
                      field.setText(text);
                      field1.setText(text);
                    }

                    originator = null;
                }

            }
        };
        field.getDocument().addDocumentListener(docListener);
        field1.getDocument().addDocumentListener(docListener);

        final DocumentFilter docFilter = new DocumentFilter(){
            @Override
            public void insertString(FilterBypass fb, int off, String str, AttributeSet attr)
                    throws BadLocationException {
                fb.insertString(off, str.replaceAll("\\D++", ""), attr);  // remove non-digits
            }

            @Override
            public void replace(FilterBypass fb, int off, int len, String str, AttributeSet attr)
                    throws BadLocationException {
                fb.replace(off, len, str.replaceAll("\\D++", ""), attr);  // remove non-digits
            }
        };
        ((AbstractDocument) field.getDocument()).setDocumentFilter(docFilter);
        ((AbstractDocument) field1.getDocument()).setDocumentFilter(docFilter);

    }
    public static void main(String[] args)
    {
        final Sh s = new Sh();
        s.setDefaultCloseOperation(EXIT_ON_CLOSE);
        s.pack();
        s.setVisible(true);
    }
}