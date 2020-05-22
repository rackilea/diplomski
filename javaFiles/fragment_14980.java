import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.StringJoiner;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import javax.swing.text.Element;

public class TestMarkup {

    public static void main(String[] args) {
        new TestMarkup();
    }

    public TestMarkup() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public static class TestPane extends JPanel {

        public TestPane() {
            setLayout(new BorderLayout());
            JTextArea ta = new JTextArea(10, 20);
            add(new JScrollPane(ta));

            ((AbstractDocument) ta.getDocument()).setDocumentFilter(new DocumentFilter() {

                protected String getLastLineOfText(Document document) throws BadLocationException {
                    // Find the last line of text...
                    Element rootElem = document.getDefaultRootElement();
                    int numLines = rootElem.getElementCount();
                    Element lineElem = rootElem.getElement(numLines - 1);
                    int lineStart = lineElem.getStartOffset();
                    int lineEnd = lineElem.getEndOffset();
                    String lineText = document.getText(lineStart, lineEnd - lineStart);
                    return lineText;
                }

                @Override
                public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                    if (text.length() > 1) {

                        String lastLineOfText = getLastLineOfText(fb.getDocument());
                        if (!lastLineOfText.startsWith("<p>")) {
                            if (!text.startsWith("<p>")) {
                                text = "<p>" + text;
                            }
                        }

                        // Replace any line breaks with a new line
                        String[] lines = text.split("\n");
                        if (lines.length > 0) {

                            StringJoiner sj = new StringJoiner("<br>\n");
                            for (String line : lines) {
                                sj.add(line);
                            }
                            text = sj.toString();

                        }

                        if (!text.endsWith("</p>")) {
                            text += "</p>";
                        }

                        super.replace(fb, offset, length, text, attrs);

                    } else {

                        String postInsert = null;
                        if (text.endsWith("\n")) {

                            // Find the last line of text...
                            String lastLineOfText = getLastLineOfText(fb.getDocument());
                            lastLineOfText = lastLineOfText.substring(0, lastLineOfText.length() - 1);
                            postInsert = "<p>";
                            if (!lastLineOfText.endsWith("</p>")) {

                                super.replace(fb, offset, 0, "</p>", attrs);
                                offset += 4;
                            }
                        }
                        super.replace(fb, offset, length, text, attrs);
                        if (postInsert != null) {
                            offset += text.length();
                            super.replace(fb, offset, 0, "<p>", attrs);
                        }
                    }
                }

            });
        }
    }
}