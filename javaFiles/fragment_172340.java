import javax.swing.*;
import javax.swing.text.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;
import java.awt.*;
import java.util.Enumeration;

public class EditorStylingExample {
    public static void main(String[] args) {
        StyleSheet styleSheet = new StyleSheet();
        styleSheet.addRule("body {font-family:\"Arial\"; font-size:12; } ");

        HTMLEditorKit messageEditorPaneHTMLEditorKit = new HTMLEditorKit();
        messageEditorPaneHTMLEditorKit.setStyleSheet(styleSheet);
        HTMLDocument document = (HTMLDocument) messageEditorPaneHTMLEditorKit.createDefaultDocument();

        JEditorPane editorPane = new JEditorPane("text/html", "");
        editorPane.setEditorKit(messageEditorPaneHTMLEditorKit);
        editorPane.setDocument(document);

        JButton changeStyleButton = new JButton("Change style");
        changeStyleButton.addActionListener(e -> {
            Style style = styleSheet.getStyle("body");
            StyleConstants.setBold(style, true);
            StyleConstants.setFontSize(style, 14);
            StyleConstants.setFontFamily(style, "Helvetica");
            printStyleAttributes(style);
            document.setCharacterAttributes(0, document.getLength(), style, true);
        });

        JFrame frame = new JFrame("Styling example");
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        contentPane.add(editorPane);
        contentPane.add(changeStyleButton);

        editorPane.setAlignmentX(Component.CENTER_ALIGNMENT);
        changeStyleButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        frame.setContentPane(contentPane);
        frame.setSize(300,300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void printStyleAttributes(Style style) {
        Enumeration styleAttributes = style.getAttributeNames();
        while (styleAttributes.hasMoreElements()) {
            Object attribute = styleAttributes.nextElement();
            String attributeName = attribute.toString();
            Object attributeValue = style.getAttribute(attribute);
            System.out.println(attributeName + ": " + attributeValue);
        }
    }
}