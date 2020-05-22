import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.DefaultCaret;

public class CaretAndJTextArea {

    private JTextArea textArea = new JTextArea();
    private static final String string =
            "Trail: Creating a GUI with JFC/Swing\n"
            + "Lesson: Learning Swing by Example\n"
            + "This lesson explains the concepts you need to\n"
            + " use Swing components in building a user interface.\n"
            + " First we examine the simplest Swing application you can write.\n"
            + " Then we present several progressively complicated examples of creating\n"
            + " user interfaces using components in the javax.swing package.\n"
            + " We cover several Swing components, such as buttons, labels, and text areas.\n"
            + " The handling of events is also discussed,\n"
            + " as are layout management and accessibility.\n"
            + " This lesson ends with a set of questions and exercises\n"
            + " so you can test yourself on what you've learned.\n"
            + "http://docs.oracle.com/javase/tutorial/uiswing/learn/index.html\n";

    public CaretAndJTextArea() {
        DefaultCaret caret = (DefaultCaret) textArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        textArea.setEditable(false);
        textArea.setEnabled(false);
        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                setModelText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                setModelText();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                setModelText();
            }

            private void setModelText() {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        //textArea.setText(textArea.getText());
                    }
                });
            }
        });
        JButton button2 = new JButton("Append String");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append(string);
            }
        });
        JFrame frame = new JFrame();
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);
        frame.add(button2, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CaretAndJTextArea();
            }
        });
    }
}