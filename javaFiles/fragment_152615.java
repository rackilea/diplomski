import java.awt.Color;
import javax.swing.*;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class ColoredTextTest {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = initgui();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    private static JFrame initgui() {
        JFrame frame = new JFrame("Test");
        JPanel panel = new JPanel();
        StyledDocument doc = (StyledDocument) new DefaultStyledDocument();
        JTextPane textpane = new JTextPane(doc);
        textpane.setText("Test");
        javax.swing.text.Style style = textpane.addStyle("Red", null);
        StyleConstants.setForeground(style, Color.RED);
        doc.setCharacterAttributes(0, 1, textpane.getStyle("Red"), true); 
        panel.add(textpane);
        frame.add(panel);
        return frame;
    }
}