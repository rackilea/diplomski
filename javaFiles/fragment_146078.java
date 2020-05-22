import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;

public class Example extends JFrame {


    public Example() {
        JComboBox comboBox = new JComboBox(new String[]{"1","2"});
        comboBox.setEditable(true);
        ((JTextComponent)comboBox.getEditor().getEditorComponent()).getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void removeUpdate(DocumentEvent arg0) {
                validateHDD(arg0);
            }

            @Override
            public void insertUpdate(DocumentEvent arg0) {
                validateHDD(arg0);
            }

            @Override
            public void changedUpdate(DocumentEvent arg0) {
                validateHDD(arg0);
            }

            private void validateHDD(DocumentEvent arg0) {
                try {
                    String text = arg0.getDocument().getText(0, arg0.getDocument().getLength());
                    if(text.equals("HDD")){
                        System.out.println("HDD entered");
                        //call your method here
                    }
                } catch (BadLocationException e) {
                    e.printStackTrace();
                }
            }

        });
        add(comboBox);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Example frame = new Example();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}