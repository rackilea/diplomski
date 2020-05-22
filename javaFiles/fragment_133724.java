import java.awt.*;
import javax.swing.*;
public class Test2 extends JFrame {
  public Test2() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container content = getContentPane();
    String[] head = {"One","Two","Three"};
    String[][] data = {{"R1-C1", "12345678", "R1-C3"},
                       {"R2-C1", "R2-C2", "R2-C3"},
                       {"R3-C1", "R3-C2", "R3-C3"}};
    JTable jt = new JTable(data, head);
    content.add(new JScrollPane(jt), BorderLayout.CENTER);
    JTextField jtf = new JTextField();
    jtf.setDocument(new LimitedPlainDocument(10));
    jt.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(jtf));
    setSize(300,300);
  }
  public static void main(String[] args) { new Test2().setVisible(true); }
}
class LimitedPlainDocument extends javax.swing.text.PlainDocument {
  private int maxLen = -1;
  /** Creates a new instance of LimitedPlainDocument */     
  public LimitedPlainDocument() {}
  public LimitedPlainDocument(int maxLen) { this.maxLen = maxLen; }
  public void insertString(int param, String str, 
                           javax.swing.text.AttributeSet attributeSet) 
                      throws javax.swing.text.BadLocationException {
    if (str != null && maxLen > 0 && this.getLength() + str.length() > maxLen) {
      java.awt.Toolkit.getDefaultToolkit().beep();
      return;
    }
    super.insertString(param, str, attributeSet);
  }
}