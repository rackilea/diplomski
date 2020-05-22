import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.BevelBorder;

public class LayoutFrame extends JFrame {
  private JPanel contentPane;
  private JMenuBar menuBar;

  public LayoutFrame() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    // Create the toolbar
    menuBar = new JMenuBar();
    menuBar.add(new JMenu("File"));
    setJMenuBar(menuBar);

    setSize(500, 500);

    contentPane = new JPanel();
    GroupLayout layout = new GroupLayout(contentPane);
    contentPane.setLayout(layout);
    setContentPane(contentPane);

    layout.setAutoCreateGaps(true);
    layout.setAutoCreateContainerGaps(true);

    // Create the panels for the different regions
    JPanel leftPanel = new JPanel();
    leftPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
    JPanel topRightPanel = new JPanel();
    topRightPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
    JPanel bottomRightPanel = new JPanel();
    bottomRightPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));

    // Create a sequential group for the horizontal axis.
    GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
    hGroup.addComponent(leftPanel);
    hGroup.addGroup(layout.createParallelGroup().
             addComponent(topRightPanel).addComponent(bottomRightPanel));
    layout.setHorizontalGroup(hGroup);

    // Create a parallel group for the vertical axis.
    GroupLayout.ParallelGroup vGroup = layout.createParallelGroup();
    vGroup.addComponent(leftPanel);
    vGroup.addGroup(layout.createSequentialGroup().
             addComponent(topRightPanel).addComponent(bottomRightPanel));
    layout.setVerticalGroup(vGroup);
  }

  public static void main(String[] args) {
    final LayoutFrame frame = new LayoutFrame();
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        frame.setVisible(true);
      }
    });
  }
}