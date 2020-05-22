import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class TextPaneWrapped {

    public static void main(String[] args) {
        new TextPaneWrapped();
    }

    public TextPaneWrapped() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                try {
                    JLabel background = new JLabel(
                            new ImageIcon(
                                    ImageIO.read(
                                            new File("background.jpg"))));
                    background.setLayout(new GridBagLayout());

                    JTextPane textPane = new JTextPane();
                    textPane.setOpaque(false);

                    Style centerStyle = textPane.addStyle("center", null);
                    StyleConstants.setAlignment(centerStyle, StyleConstants.ALIGN_CENTER);
                    StyleConstants.setFontFamily(centerStyle, textPane.getFont().getFamily());
                    textPane.setParagraphAttributes(centerStyle, true);

                    Style defaultStyle = textPane.addStyle("defaultStyle", centerStyle);
                    StyleConstants.setFontSize(defaultStyle, 24);

                    Style capWord = textPane.addStyle("capWord", defaultStyle);
                    StyleConstants.setForeground(capWord, Color.RED);
                    StyleConstants.setFontSize(capWord, 48);

                    StyledDocument doc = textPane.getStyledDocument();
                    try {
                        doc.insertString(0, "H", capWord);
                        doc.insertString(1, "ello ", defaultStyle);
                        doc.insertString(doc.getLength(), "W", capWord);
                        doc.insertString(doc.getLength(), "orld", defaultStyle);
                    } catch (BadLocationException exp) {
                        exp.printStackTrace();
                    }

                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.insets = new Insets(40, 40, 40, 40);
                    gbc.fill = GridBagConstraints.BOTH;
                    gbc.weightx = 1;
                    gbc.weighty = 1;
                    background.add(textPane, gbc);

                    JFrame frame = new JFrame("Testing");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.add(background);
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (IOException exp) {
                    exp.printStackTrace();
                }
            }
        });
    }

}