import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;

public class ElementEndOffsetTest {

    public JComponent makeUI() {
        String str = "name : andy\n"
                + "birth : jakarta, 1 jan 1990\n"
                + "number id : 01011990 01\n"
                + "age : 26\n"
                + "study : Informatics engineering\n";

        JTextArea textArea = new JTextArea(str);
        textArea.setEditable(false);
        JPanel p = new JPanel(new BorderLayout());
        p.add(new JScrollPane(textArea));
        p.add(new JButton(new AbstractAction("add") {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Document doc = textArea.getDocument();
                    Element root = doc.getDefaultRootElement();
                    Element element = root.getElement(2);
                    int start = element.getStartOffset();
                    int end = element.getEndOffset();
                    System.out.println(doc.getText(start, end - start));
                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }
            }
        }), BorderLayout.SOUTH);
        return p;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame f = new JFrame();
            f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            f.getContentPane().add(new ElementEndOffsetTest().makeUI());
            f.setSize(320, 240);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        });
    }
}