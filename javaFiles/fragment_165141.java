import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.Element;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;

public class TestHyperlinks {

    private final class HyperlinkMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON3) {
                Element h = getHyperlinkElement(e);
                if (h != null) {
                    Object attribute = h.getAttributes().getAttribute(HTML.Tag.A);
                    if (attribute instanceof AttributeSet) {
                        AttributeSet set = (AttributeSet) attribute;
                        String href = (String) set.getAttribute(HTML.Attribute.HREF);
                        if (href != null) {
                            try {
                                Desktop.getDesktop().browse(new URI(href));
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            } catch (URISyntaxException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                }
            }
        }

        private Element getHyperlinkElement(MouseEvent event) {
            JEditorPane editor = (JEditorPane) event.getSource();
            int pos = editor.getUI().viewToModel(editor, event.getPoint());
            if (pos >= 0 && editor.getDocument() instanceof HTMLDocument) {
                HTMLDocument hdoc = (HTMLDocument) editor.getDocument();
                Element elem = hdoc.getCharacterElement(pos);
                if (elem.getAttributes().getAttribute(HTML.Tag.A) != null) {
                    return elem;
                }
            }
            return null;
        }
    }

    protected void initUI() {
        JPanel panel = new JPanel(false);

        JEditorPane gentextp = new JTextPane();
        JScrollPane scrollPane = new JScrollPane(gentextp);
        panel.add(scrollPane);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        gentextp.setContentType("text/html");
        gentextp.setEditable(false);
        gentextp.setPreferredSize(new Dimension(500, 400));
        gentextp.addMouseListener(new HyperlinkMouseListener());
        gentextp.setText("Some text containing an hyperlink: <a href=\"http://www.stackoverflow.com\">a link to stackoverflow</a> and some more text not in an hyperlink");

        JFrame f = new JFrame(TestHyperlinks.class.getSimpleName());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(panel, BorderLayout.CENTER);
        f.pack();
        f.setSize(f.getWidth() + 100, f.getHeight() + 100);
        f.setVisible(true);

    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestHyperlinks().initUI();
            }
        });
    }

}