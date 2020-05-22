import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SpinnerLayoutTest {
  public JComponent makeUI() {
    SpinnerNumberModel m = new SpinnerNumberModel(10, 0, 1000, 1);
    JSpinner spinner = new JSpinner(m) {
      @Override public void setLayout(LayoutManager mgr) {
        super.setLayout(new SpinnerLayout());
      }
    };
    JPanel p = new JPanel(new BorderLayout(5,5));
    p.add(new JSpinner(m), BorderLayout.NORTH);
    p.add(spinner, BorderLayout.SOUTH);
    p.setBorder(BorderFactory.createEmptyBorder(16,16,16,16));
    return p;
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
    f.getContentPane().add(new SpinnerLayoutTest().makeUI());
    f.setSize(320, 160);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
  }
}
class SpinnerLayout extends BorderLayout {
  @Override public void addLayoutComponent(Component comp, Object constraints) {
    if("Editor".equals(constraints)) {
      constraints = "Center";
    } else if("Next".equals(constraints)) {
      constraints = "North";
    } else if("Previous".equals(constraints)) {
      constraints = "South";
    }
    super.addLayoutComponent(comp, constraints);
  }
}