import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;

public class Fonts implements Runnable {

    private String[] fnt;
    private JFrame frm;
    private JScrollPane jsp;
    private JTextPane jta;
    private int width = 450;
    private int height = 300;
    private GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    private StyledDocument doc;
    private MutableAttributeSet mas;
    private int cp = 0;
    private Highlighter.HighlightPainter cyanPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.cyan);
    private Highlighter.HighlightPainter redPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.red);
    private Highlighter.HighlightPainter whitePainter = new DefaultHighlighter.DefaultHighlightPainter(Color.white);
    private int _count = 0;
    private int _lenght = 0;

    public Fonts() {
        jta = new JTextPane();
        doc = jta.getStyledDocument();
        jsp = new JScrollPane(jta);
        jsp.setPreferredSize(new Dimension(height, width));
        frm = new JFrame("awesome");
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLayout(new BorderLayout());
        frm.add(jsp, BorderLayout.CENTER);
        frm.setLocation(100, 100);
        frm.pack();
        frm.setVisible(true);
        jta.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        fnt = ge.getAvailableFontFamilyNames();
        mas = jta.getInputAttributes();
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < fnt.length; i++) {
            StyleConstants.setBold(mas, false);
            StyleConstants.setItalic(mas, false);
            StyleConstants.setFontFamily(mas, fnt[i]);
            StyleConstants.setFontSize(mas, 16);
            dis(fnt[i]);
            try {
                Thread.sleep(75);
            } catch (Exception e) {
                e.printStackTrace();
            }
            StyleConstants.setBold(mas, true);
            dis(fnt[i] + " Bold");
            try {
                Thread.sleep(75);
            } catch (Exception e) {
                e.printStackTrace();
            }
            StyleConstants.setItalic(mas, true);
            dis(fnt[i] + " Bold & Italic");
            try {
                Thread.sleep(75);
            } catch (Exception e) {
                e.printStackTrace();
            }
            StyleConstants.setBold(mas, false);
            dis(fnt[i] + " Italic");
            try {
                Thread.sleep(75);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        jta.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    public void dis(String s) {
        _count++;
        _lenght = jta.getText().length();
        try {
            doc.insertString(cp, s, mas);
            doc.insertString(cp, "\n", mas);
        } catch (Exception bla_bla_bla_bla) {
            bla_bla_bla_bla.printStackTrace();
        }
        if (_count % 2 == 0) {
            try {
                jta.getHighlighter().addHighlight(1, _lenght - 1, cyanPainter);
            } catch (BadLocationException bla_bla_bla_bla) {
            }
        } else if (_count % 3 == 0) {
            try {
                jta.getHighlighter().addHighlight(1, _lenght - 1, redPainter);
            } catch (BadLocationException bla_bla_bla_bla) {
            }
        } else {
            try {
                jta.getHighlighter().addHighlight(1, _lenght - 1, whitePainter);
            } catch (BadLocationException bla_bla_bla_bla) {
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                JDialog.setDefaultLookAndFeelDecorated(true);
                try {
                    UIManager.setLookAndFeel(new org.pushingpixels.substance.api.skin.SubstanceBusinessBlackSteelLookAndFeel());
                } catch (UnsupportedLookAndFeelException ex) {
                }
                Fonts fs = new Fonts();
            }
        });
    }
}