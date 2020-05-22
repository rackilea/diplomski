import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.text.AttributeSet;
import javax.swing.*;
import javax.swing.text.*;

 public class TesxtPane {

public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {

        @Override
        public void run() {
            // TODO Auto-generated method stub
            JFrame frame = new TextStyleTestFrame();
            frame.setSize(300, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
    });
 }
}
class TextStyleTestFrame extends JFrame {
private JButton btnStyle = new JButton("Bold");
private JTextPane textPane = new JTextPane();

public TextStyleTestFrame() {
    super("TextPaneStyle Test");
    textPane.setText("Smaple String");
    this.add(textPane, BorderLayout.CENTER);
    JPanel panel = new JPanel();
    panel.add(btnStyle);
    this.add(panel, BorderLayout.NORTH);
    btnStyle.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            changeStyle();
        }
    });
}


private void changeStyle() {

    //get selected text style
    int start = textPane.getSelectionStart();
    int end = textPane.getSelectionEnd();

    if (start == end) {
        return;
    }
    StyledDocument doc = (StyledDocument) textPane.getDocument();
    Element element = doc.getCharacterElement(start);
    AttributeSet as = element.getAttributes();
    //apply a new style based on previous 
    MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
    StyleConstants.setBold(asNew, !StyleConstants.isBold(as));
    doc.setCharacterAttributes(start, textPane.getSelectedText().length(), asNew, true);
    String text = (StyleConstants.isBold(as) ? "Cancel Bold" : "Bold");
    btnStyle.setText(text);
    boolean isBold = StyleConstants.isBold(as) ? false : true;
    boolean isItalic = StyleConstants.isItalic(as);
    System.out.println("selected value is isItalic?" + isItalic);
    System.out.println("selected value is isBold?" + isBold);
   }

}