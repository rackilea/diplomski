import java.awt.*;
import java.net.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.text.html.*;

public class ImgBaselineTest {
  private JComponent makeUI() {
    JEditorPane editor2 = makeEditorPane(new ImgBaselineHTMLEditorKit());
    JEditorPane editor1 = makeEditorPane(new HTMLEditorKit());
    JPanel p = new JPanel(new GridLayout(2, 1));
    p.add(new JScrollPane(editor1));
    p.add(new JScrollPane(editor2));
    return p;
  }
  private JEditorPane makeEditorPane(HTMLEditorKit kit) {
    JEditorPane jep = new JEditorPane();
    jep.setContentType("text/html");
    jep.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);
    // HTMLEditorKit kit = new HTMLEditorKit();
    // HTMLEditorKit kit = new ImgBaselineHTMLEditorKit();
    jep.setEditorKit(kit);
    StyleSheet styleSheet = kit.getStyleSheet();
    styleSheet.addRule("span {color:orange; font-family:times; margin: 4px; display: inline; line-height: 20px;}");
    styleSheet.addRule("img {padding-top: 10; align: middle; valign: middle; vertical-align: middle; }");

    //URL url = ImgBaselineTest.class.getResource("16x16.png");
    String url = "https://i.stack.imgur.com/MOQoc.png";
    // jep.setText("<span>Hello computer! <img src='" + url + "' width='20' height='20' valign='middle'></span>");
    jep.setText("<span>Hello computer! <img src='" + url + "''></span>");
    return jep;
  }
  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      f.getContentPane().add(new ImgBaselineTest().makeUI());
      f.setSize(320, 240);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
    });
  }
}

class ImgBaselineHTMLEditorKit extends HTMLEditorKit {
  @Override public ViewFactory getViewFactory() {
    return new HTMLEditorKit.HTMLFactory() {
      @Override public View create(Element elem) {
        View view = super.create(elem);
        if (view instanceof LabelView) {
          System.out.println(view.getAlignment(View.Y_AXIS));
        }
        AttributeSet attrs = elem.getAttributes();
        Object elementName = attrs.getAttribute(AbstractDocument.ElementNameAttribute);
        Object o = elementName != null ? null : attrs.getAttribute(StyleConstants.NameAttribute);
        if (o instanceof HTML.Tag) {
          HTML.Tag kind = (HTML.Tag) o;
          if (kind == HTML.Tag.IMG) {
            return new ImageView(elem) {
              @Override public float getAlignment(int axis) {
                switch (axis) {
                case View.Y_AXIS:
                  return .8125f; // magic number...
                default:
                  return super.getAlignment(axis);
                }
              }
            };
          }
        }
        return view;
      }
    };
  }
}