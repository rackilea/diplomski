import javax.swing.*;
import javax.swing.plaf.*;
import java.awt.event.*;

public class JTabBug{

    public static void main(String[] args) {

      JTabbedPane jTabbedPane = new JTabbedPane()
      {
        @Override
        public String getToolTipText(MouseEvent e)
        {
            int index = ((TabbedPaneUI)ui).tabForCoordinate(this, e.getX(), e.getY());

            if (index != -1)
            {
                JComponent component = (JComponent)getTabComponentAt(index);
                return component.getToolTipText();
            }

            return super.getToolTipText(e);
        }
      };
      ToolTipManager.sharedInstance().registerComponent(jTabbedPane);
      jTabbedPane.addTab("Red", new JLabel("Roses"));
      jTabbedPane.addTab("Blue", new JLabel("Skies"));
      jTabbedPane.addTab("Green", new JLabel("Grass"));

      for (int i = 0; i < jTabbedPane.getTabCount(); i++) {
        JLabel tabComponent = new JLabel(jTabbedPane.getTitleAt(i));
        tabComponent.setToolTipText("Tip: " + tabComponent.getText());
        ToolTipManager.sharedInstance().unregisterComponent(tabComponent);
        jTabbedPane.setTabComponentAt(i, tabComponent);
      }

      JFrame jFrame = new JFrame("Testing");
      jFrame.add(jTabbedPane);
      jFrame.setSize(400, 500);
      jFrame.setVisible(true);
      jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}