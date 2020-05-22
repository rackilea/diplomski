import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class MySearch02 {

    public static void main(String[] args) {
        new MySearch02();
    }

    public MySearch02() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JTextField findText;
        private JTextArea ta;
        private Timer keyTimer;

        public TestPane() {
            setLayout(new BorderLayout());
            JPanel searchPane = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(2, 2, 2, 2);
            searchPane.add(new JLabel("Find: "), gbc);
            gbc.gridx++;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.weightx = 1;
            findText = new JTextField(20);
            searchPane.add(findText, gbc);

            add(searchPane, BorderLayout.NORTH);

            ta = new JTextArea(20, 40);
            ta.setWrapStyleWord(true);
            ta.setLineWrap(true);
            ta.setEditable(false);
            add(new JScrollPane(ta));

            loadFile();

            keyTimer = new Timer(250, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String find = findText.getText();
                    Document document = ta.getDocument();
                    try {
                        for (int index = 0; index + find.length() < document.getLength(); index++) {
                            String match = document.getText(index, find.length());
                            if (find.equals(match)) {
                                javax.swing.text.DefaultHighlighter.DefaultHighlightPainter highlightPainter =
                                        new javax.swing.text.DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
                                ta.getHighlighter().addHighlight(index, index + find.length(),
                                        highlightPainter);
                            }
                        }
                    } catch (BadLocationException exp) {
                        exp.printStackTrace();
                    }
                }
            });
            keyTimer.setRepeats(false);

            findText.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    keyTimer.restart();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    keyTimer.restart();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    keyTimer.restart();
                }
            });
        }

        protected void loadFile() {
            String searchText = findText.getText();
            try (BufferedReader reader = new BufferedReader(new FileReader(new File("search.txt")))) {
                ta.read(reader, "Text");
            } catch (IOException exp) {
                exp.printStackTrace();
                JOptionPane.showMessageDialog(TestPane.this, "Could not create file", "Error", JOptionPane.ERROR_MESSAGE);
            }
            ta.setCaretPosition(0);
        }
    }
}