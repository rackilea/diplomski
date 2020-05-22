import java.awt.*;
import javax.swing.*;
public class BaselineTest {
  public JComponent makeUI() {
    JLabel label1 = makeLabel();
    JLabel label2 = makeLabel();
    String s = "For detailed infomation refer: ";
    JTextPane textPane = new JTextPane();
    textPane.replaceSelection(s);
    textPane.insertComponent(label1);

    Dimension d = label2.getPreferredSize();
    int baseline = label2.getBaseline(d.width, d.height);
    label2.setAlignmentY(baseline/(float)d.height);
    textPane.replaceSelection("\n\n"+s);
    textPane.insertComponent(label2);

    return new JScrollPane(textPane);
  }
  private static JLabel makeLabel() {
    JLabel label = new JLabel("2012-10-05");
    label.setForeground(Color.BLUE);
    label.setOpaque(false);
    return label;
  }
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override public void run() {
        createAndShowGUI();
      }
    });
  }
  public static void createAndShowGUI() {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    f.getContentPane().add(new BaselineTest().makeUI());
    f.setSize(320, 240);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
  }
}