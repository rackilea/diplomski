import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.metal.*;

public class CustomTabWidthDemo implements Runnable
{
  public static void main(String[] args)
  {
    SwingUtilities.invokeLater(new CustomTabWidthDemo());
  }

  public void run()
  {
    JTabbedPane tabbedPane = new JTabbedPane();
    tabbedPane.setUI(new MetalTabbedPaneUI()
    {
      @Override
      protected int calculateTabWidth(int tabPlacement, int tabIndex,
                                      FontMetrics metrics)
      {
        int width = super.calculateTabWidth(tabPlacement, tabIndex, metrics);
        int extra = tabIndex * 50;
        return width + extra;
      }
    });

    tabbedPane.addTab("JTable", new JScrollPane(new JTable(5,5)));
    tabbedPane.addTab("JTree", new JScrollPane(new JTree()));
    tabbedPane.addTab("JSplitPane", new JSplitPane());

    JPanel p = new JPanel();
    p.add(tabbedPane);

    JFrame frame = new JFrame();
    frame.setContentPane(p);
    frame.pack();
    frame.setVisible(true);
  }
}