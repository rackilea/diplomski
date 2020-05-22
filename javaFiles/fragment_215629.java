import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;

/** @see http://stackoverflow.com/questions/8283067 */
public class DocumentListeners extends JPanel implements DocumentListener {

    JTextField jtf = new JTextField("StackOverflow!");

    public DocumentListeners() {
        this.add(jtf);
        jtf.getDocument().addDocumentListener(this);
        jtf.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                print(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                print(e);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                print(e);
            }
        });
    }

    private void print(DocumentEvent e) {
        AbstractDocument ad = (AbstractDocument) jtf.getDocument();
        for (DocumentListener dl : ad.getListeners(DocumentListener.class)) {
            System.out.println(dl);
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        print(e);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        print(e);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        print(e);
    }

    private void display() {
        JFrame f = new JFrame("DocumentListeners");
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
                new DocumentListeners().display();
            }
        });
    }
}