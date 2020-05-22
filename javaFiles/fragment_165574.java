import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.*;

public class JTabbedPaneWithSpaces implements Runnable
{
  public static void main(String[] args) throws Exception
  {
    SwingUtilities.invokeLater(new JTabbedPaneWithSpaces());
  }

  public void run()
  {
    JTabbedPane pane = new JTabbedPane();
    pane.setUI(new SpacedTabbedPaneUI());
    pane.addTab("One", new JPanel());
    pane.addTab("Two", new JPanel());
    pane.addTab("Threeeeeee", new JPanel());
    pane.addTab("Four", new JPanel());

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(pane);
    frame.setSize(500, 200);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  public class SpacedTabbedPaneUI extends BasicTabbedPaneUI
  {
    @Override
    protected LayoutManager createLayoutManager()
    {
      return new BasicTabbedPaneUI.TabbedPaneLayout()
      {
        @Override
        protected void calculateTabRects(int tabPlacement, int tabCount)
        {
          final int spacer = 20; // should be non-negative
          final int indent = 4;

          super.calculateTabRects(tabPlacement,tabCount);

          for (int i = 0; i < rects.length; i++)
          { 
            rects[i].x += i * spacer + indent;
          } 
        }
      };
    }
  }
}