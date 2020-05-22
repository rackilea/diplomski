public class DialogTest {
public static void main(String[] args) throws Exception {
    JTextPane jtp = new JTextPane();
    Document doc = jtp.getDocument();
    for (int i = 0; i < 50; i++) {
        doc.insertString(doc.getLength(), " Hello Java World ", new SimpleAttributeSet());
        if ((3 == i) || (7 == i) || (15 == i)) {
            doc.insertString(doc.getLength(), " Hello Java World ", new SimpleAttributeSet());
            SimpleAttributeSet attrs = new SimpleAttributeSet();
            StyleConstants.setUnderline(attrs, true);
            StyleConstants.setForeground(attrs, Color.BLUE);
            String text = "www.google.com";
            URL url = new URL("http://" + text);
            attrs.addAttribute(HTML.Attribute.HREF, url.toString());
            doc.insertString(doc.getLength(), text, attrs);
        }
    }
    //JScrollPane jsp = new JScrollPane(jtp);
    //jsp.setPreferredSize(new Dimension(480, 150));
    //jsp.setBorder(null);
    jtp.setSize(new Dimension(480, 10));
    jtp.setPreferredSize(new Dimension(480, jtp.getPreferredSize().height));

    //JOptionPane.showMessageDialog(null, jsp, "Title", JOptionPane.INFORMATION_MESSAGE);
    JOptionPane.showMessageDialog(null, jtp, "Title", JOptionPane.INFORMATION_MESSAGE);
}}