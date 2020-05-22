import java.awt.Dimension;
import java.awt.Image;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.Utilities;

public class JTextPaneWithEmoticon {

    private JFrame frame;
    private JTextPane textPane;
    static ImageIcon smiley, sad;
    static final String SMILEY_EMOTICON = ":)", SAD_EMOTICON = ":(";
    String[] emoticons = {SMILEY_EMOTICON, SAD_EMOTICON};

    private void initComponents() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textPane = new JTextPane();

        //add docuemntlistener to check for emoticon insert i.e :)
        ((AbstractDocument) textPane.getDocument()).addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(final DocumentEvent de) {
                //We should surround our code with SwingUtilities.invokeLater() because we cannot change document during mutation intercepted in the listener.
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            StyledDocument doc = (StyledDocument) de.getDocument();
                            int start = Utilities.getRowStart(textPane, Math.max(0, de.getOffset() - 1));
                            int end = Utilities.getWordStart(textPane, de.getOffset() + de.getLength());

                            String text = doc.getText(start, end - start);

                            for (String emoticon : emoticons) {//for each emoticon

                                int i = text.indexOf(emoticon);
                                while (i >= 0) {
                                    final SimpleAttributeSet attrs = new SimpleAttributeSet(doc.getCharacterElement(start + i).getAttributes());
                                    if (StyleConstants.getIcon(attrs) == null) {

                                        switch (emoticon) {//check which emtoticon picture to apply
                                            case SMILEY_EMOTICON:
                                                StyleConstants.setIcon(attrs, smiley);
                                                break;
                                            case SAD_EMOTICON:
                                                StyleConstants.setIcon(attrs, sad);
                                                break;
                                        }

                                        doc.remove(start + i, emoticon.length());
                                        doc.insertString(start + i, emoticon, attrs);
                                    }
                                    i = text.indexOf(emoticon, i + emoticon.length());
                                }
                            }
                        } catch (BadLocationException ex) {
                            ex.printStackTrace();
                        }
                    }
                });
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });

        JScrollPane scrollPane = new JScrollPane(textPane);
        scrollPane.setPreferredSize(new Dimension(300, 300));

        frame.add(scrollPane);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        try {//attempt to get icon for emoticons
            smiley = new ImageIcon(ImageIO.read(new URL("http://facelets.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/e/m/emoticons0001.png")).getScaledInstance(24, 24, Image.SCALE_SMOOTH));
            sad = new ImageIcon(ImageIO.read(new URL("http://zambia.primaryblogger.co.uk/files/2012/04/sad.jpg")).getScaledInstance(24, 24, Image.SCALE_SMOOTH));

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JTextPaneWithEmoticon().initComponents();
            }
        });
    }
}