import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class Foo2 extends JPanel {
   private static final Color NEW_COLOR = new Color(112,253,95);
   private static final int PREF_W = 400;
   private static final int PREF_H = PREF_W;
   private JMenuBar menuBar = new JMenuBar();

   public Foo2() {
      JMenuItem chameleon = new JMenuItem(new ChangeColorAction("Change Color")); 
      JMenu menu = new JMenu("Menu");
      menu.add(chameleon);
      menuBar.add(menu);
   }

   public JMenuBar getMenuBar() {
      return menuBar;
   }

   @Override
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(PREF_W, PREF_H);
   }

   private class ChangeColorAction extends AbstractAction {
      public ChangeColorAction(String name) {
         super(name);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         setBackground(NEW_COLOR);
      }
   }

   private static void createAndShowGui() {
      Foo2 mainPanel = new Foo2();

      JFrame frame = new JFrame("Foo2");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.setJMenuBar(mainPanel.getMenuBar());
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}