//include imports to make code MCVE
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

//use right java naming convention
public class GuiFrame {
    JLabel label;
    JMenuBar menubar;
    JTextArea area;

    public GuiFrame() throws BadLocationException {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(600,200));
        frame.getContentPane().setBackground(Color.BLACK);

        //no point in assigning BorderLayout which is not used
        //JPanel panel = new JPanel(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        panel.setBackground(Color.BLACK);
        frame.add(panel);

        //remove what is not essential for the question
        //to make code and MCVE
        //JMenuBar menubar = new JMenuBar();


        //to set horizontal alignment you need to use a JTextpane
        //JTextArea area = new JTextArea("Hallo, Welt! Hier kann man Text reinschreiben...");
        String text = "Hallo, Welt! Hier kann man Text reinschreiben...";
        StyleContext context = new StyleContext();
        StyledDocument document = new DefaultStyledDocument(context);

        Style style = context.getStyle(StyleContext.DEFAULT_STYLE);
        StyleConstants.setAlignment(style, StyleConstants.ALIGN_LEFT);

        document.insertString(document.getLength(), text, style);
        JTextPane area = new JTextPane(document);
        panel.add(area);

        //vertical alignment is not supported.
        //see possible solutions here: http:
        //stackoverflow.com/questions/29148464/align-jtextarea-bottom

        //remove what is not essential for the question
        //to make code and MCVE
        //JMenuBar menubar = new JMenuBar();
        //JLabel label = new JLabel("");

        frame.setVisible(true);
    }

    //include a main to make code an MCVE
    public static void main(String[] args) {

        try {
            new GuiFrame();
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
    }
}