public class OuterClass {
InnerClass inner = new InnerClass();

private class InnerClass {
    private JTextPane textPane = new JTextPane();
    private Font firstFont = new Font("Times New Roman", Font.PLAIN, 18);
    private Font secondFont = new Font("Calibri", Font.PLAIN, 14);
    StyledDocument doc = textPane.getStyledDocument();
    SimpleAttributeSet aSet = new SimpleAttributeSet();

    public InnerClass() {
        StyledDocument doc = textPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
    }

    public void useFont1() {
        StyleConstants.setFontFamily(aSet, firstFont.getFamily());
        StyleConstants.setFontSize(aSet, firstFont.getSize());
        doc.setParagraphAttributes(0, 0, aSet, false);
    }

    public void useFont2() {
        StyleConstants.setFontFamily(aSet, secondFont.getFamily());
        StyleConstants.setFontSize(aSet, secondFont.getSize());
        doc.setParagraphAttributes(doc.getLength(), 0, aSet, false);
    }
}

public void decorateTextPane() {
    inner.useFont1();
    inner.textPane.setText("First string");
    inner.useFont2();
    inner.textPane.append("\nSecond string"); //my textPane class defines an append method.
}