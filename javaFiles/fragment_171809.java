import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringBufferInputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

public class SSCCE extends JFrame {

    public SSCCE() {
        final JTextArea aMain = new JTextArea();
        aMain.setFont(new Font("Consolas", Font.PLAIN, 11));
        aMain.setMargin(new Insets(5, 5, 5, 5));
        aMain.setEditable(false);
        add(aMain);

        aMain.setText("The quick brown fox jumped over the lazy dog.");
        Highlighter h = aMain.getHighlighter();
        try {
            h.addHighlight(10, 15, new DefaultHighlighter.DefaultHighlightPainter(new Color(0xFFC800)));
        } catch (BadLocationException e) {
            e.printStackTrace();
        }

        aMain.getActionMap().put("Copy", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                Highlighter h = aMain.getHighlighter();
                Highlighter.Highlight[] highlights = h.getHighlights();
                StringBuilder sb = new StringBuilder(64);
                sb.append("<html><body>");
                boolean markedUp = false;
                for (Highlighter.Highlight highlight : highlights) {
                    int start = highlight.getStartOffset();
                    int end = highlight.getEndOffset();

                    try {
                        String text = aMain.getDocument().getText(start, end - start);

                        sb.append("<span style = 'background-color: #FFC800'>");
                        sb.append(text);
                        sb.append("</span>");
                        markedUp = true;
                    } catch (BadLocationException ex) {
                        ex.printStackTrace();
                    }
                }
                sb.append("</body></html>");
                if (markedUp) {
                    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                    clipboard.setContents(new HtmlSelection(sb.toString()), null);
                }
            }
        });
        aMain.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_C, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()), "Copy");

        setTitle("SSCCE");
        setSize(350, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SSCCE();
            }
        });
    }

    private static class HtmlSelection implements Transferable {

        private static List<DataFlavor> htmlFlavors = new ArrayList<>(3);

        static {

            try {
                htmlFlavors.add(new DataFlavor("text/html;class=java.lang.String"));
                htmlFlavors.add(new DataFlavor("text/html;class=java.io.Reader"));
                htmlFlavors.add(new DataFlavor("text/html;charset=unicode;class=java.io.InputStream"));
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }

        }

        private String html;

        public HtmlSelection(String html) {
            this.html = html;
        }

        public DataFlavor[] getTransferDataFlavors() {
            return (DataFlavor[]) htmlFlavors.toArray(new DataFlavor[htmlFlavors.size()]);
        }

        public boolean isDataFlavorSupported(DataFlavor flavor) {
            return htmlFlavors.contains(flavor);
        }

        public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException {
            if (String.class.equals(flavor.getRepresentationClass())) {
                return html;
            } else if (Reader.class.equals(flavor.getRepresentationClass())) {
                return new StringReader(html);
            } else if (InputStream.class.equals(flavor.getRepresentationClass())) {
                return new StringBufferInputStream(html);
            }
            throw new UnsupportedFlavorException(flavor);
        }
    }
}