import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

public class TestText {

    public static void main(String[] args) {
        new TestText();
    }

    public TestText() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JTextPane tp = new JTextPane();
                tp.replaceSelection("Asd, asd, asd, fgh ");
                addField(tp);
                tp.replaceSelection(" more funky text here ");
                addField(tp);
                tp.replaceSelection(" and this must wrap on the edge. The color code of red is: #");
                addField(tp);
                tp.replaceSelection(". ");
                tp.setEditable(false);

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new JScrollPane(tp));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

            protected void addField(JTextPane tp) {
                JTextField field = new JTextField(10);
                field.setAlignmentY(0.75f);
                tp.insertComponent(field);
            }
        });
    }

}