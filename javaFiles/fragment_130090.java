import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.Element;
import javax.swing.text.StyleConstants;
import javax.swing.text.View;
import javax.swing.text.ViewFactory;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.InlineView;
import javax.swing.text.html.StyleSheet;

public class CodePaddingMCVE {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Code Padding Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JTextPane tp = new JTextPane();
                tp.setContentType("text/html");

                HTMLEditorKit kit = new HTMLEditorKit() {
                    public ViewFactory getViewFactory() {
                        return new HTMLFactory() {
                            public View create(Element elem) {
                                AttributeSet attrs = elem.getAttributes();
                                Object elementName =
                                    attrs.getAttribute(AbstractDocument.ElementNameAttribute);
                                Object o = (elementName != null) ?
                                    null : attrs.getAttribute(StyleConstants.NameAttribute);
                                if (o instanceof HTML.Tag) {
                                    HTML.Tag kind = (HTML.Tag) o;
                                    if (kind == HTML.Tag.CONTENT) {
                                        return new InlineView(elem) {
                                            private short left;
                                            private short right;
                                            private short top;
                                            private short bottom;
                                            protected void setPropertiesFromAttributes() {
                                                AttributeSet attr = getAttributes();
                                                if (attr != null) {
                                                    top = (short) StyleConstants.getSpaceAbove(attr);
                                                    left = (short) StyleConstants.getLeftIndent(attr);
                                                    bottom = (short) StyleConstants.getSpaceBelow(attr);
                                                    right = (short) StyleConstants.getRightIndent(attr);
                                                }
                                                super.setPropertiesFromAttributes();
                                            }
                                            //TODO : use the top, left, bottom and right properties to draw the margin/padding
                                        };
                                    }
                                }
                                return super.create(elem);
                            }
                        };
                    }
                };
                tp.setEditorKit(kit);
                StyleSheet sheet = kit.getStyleSheet();
                sheet.addRule("span {padding: 5px 5px 5px 5px; background-color: red}"); //Using span here
                sheet.addRule("pre {padding: 0px; background-color: green}");
                tp.setDocument(kit.createDefaultDocument());
                tp.setText("<html><pre>NotCode<span>Code</span>NotCode</pre></html>"); //Using <span> here too

                JScrollPane sp = new JScrollPane(tp) {
                    private static final long serialVersionUID = 1L;

                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(250, 50);
                    }

                };

                frame.getContentPane().add(sp);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}