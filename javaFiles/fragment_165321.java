/**
 * @see http://stackoverflow.com/a/15669307/230513
 * @see http://stackoverflow.com/questions/2883413
 */
public class DocumentParse {

    private static final String ELEM = AbstractDocument.ElementNameAttribute;
    private static final String ICON = StyleConstants.IconElementName;
    private static final String COMP = StyleConstants.ComponentElementName;

    public static void main(String args[]) throws Exception {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextPane jtp = new JTextPane();
        StyledDocument doc = (StyledDocument) jtp.getDocument();
        SimpleAttributeSet normal = new SimpleAttributeSet();
        StyleConstants.setFontFamily(normal, "Serif");
        StyleConstants.setFontSize(normal, 72);
        StyleConstants.setForeground(normal, Color.blue);
        doc.insertString(doc.getLength(), "Test", normal);
        jtp.setSelectionStart(doc.getLength());
        jtp.insertIcon(UIManager.getIcon("OptionPane.warningIcon"));
        jtp.setSelectionStart(doc.getLength());
        jtp.insertComponent(new JLabel("Label"));
        jtp.setSelectionStart(doc.getLength());

        ElementIterator iterator = new ElementIterator(doc);
        Element element;
        while ((element = iterator.next()) != null) {
            System.out.println(element);
            AttributeSet as = element.getAttributes();
            if (as.containsAttribute(ELEM, ICON)) {
                System.out.println(StyleConstants.getIcon(as).getClass());
            }
            if (as.containsAttribute(ELEM, COMP)) {
                System.out.println(StyleConstants.getComponent(as).getClass());
            }
        }

        f.add(jtp);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}