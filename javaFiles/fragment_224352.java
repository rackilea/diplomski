import java.awt.Dimension;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class BugWrapJava7 {

    private JFrame frame = new JFrame();
    private JTextPane jtp;
    private StyledDocument doc;

    public BugWrapJava7() {
        jtp = new JTextPane();
        jtp.setText("\ntype some text in the above empty line and check the wrapping behavior");
        doc = jtp.getStyledDocument();
        doc.addDocumentListener(new DocumentListener() {

            public void insertUpdate(DocumentEvent e) {
                insert();
            }

            public void removeUpdate(DocumentEvent e) {
                insert();
            }

            public void changedUpdate(DocumentEvent e) {
                insert();
            }

            public void insert() {
                SwingUtilities.invokeLater(new Runnable() {

                    public void run() {
                        Style defaultStyle = jtp.getStyle(StyleContext.DEFAULT_STYLE);
                        doc.setCharacterAttributes(0, doc.getLength(), defaultStyle, false);
                    }
                });
            }
        });
        JScrollPane scroll = new JScrollPane(jtp);
        scroll.setPreferredSize(new Dimension(200, 200));
        frame.add(scroll);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                BugWrapJava7 bugWrapJava7 = new BugWrapJava7();
            }
        });
    }
}