import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class TestGui2 extends JFrame {
  private static JPanel createCenterFrame() {
    Border raisedBevel = BorderFactory.createRaisedBevelBorder();
    Border lineBorder = BorderFactory.createMatteBorder(10, 0, 0, 0, Color.GRAY.brighter());
    Border loweredBevel = BorderFactory.createLoweredBevelBorder();
    Border compound1 = BorderFactory.createCompoundBorder(raisedBevel, lineBorder);
    Border compound2 = BorderFactory.createCompoundBorder(compound1, loweredBevel);
    TitledBorder topFrameTitle = BorderFactory.createTitledBorder(compound2, "Character");
    topFrameTitle.setTitleJustification(TitledBorder.CENTER);

    JPanel pnl = new JPanel();
    pnl.setBorder(topFrameTitle);
    return pnl;
  }
  TestGui2() {
    add(createCenterFrame(), BorderLayout.CENTER);
    setSize(400, 175);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  public static void main(String[] args) {
    EventQueue.invokeLater(() -> new TestGui2());
  }
}