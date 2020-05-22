import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class TestMouseRelease extends JPanel {
   private String[] panelNames = { "Panel A", "Panel B" };

   public TestMouseRelease() {
      setLayout(new GridLayout(1, 0));
      MouseAdapter mAdapter = new MyMouseAdapter();

      addMouseListener(mAdapter);
      addMouseMotionListener(mAdapter);

      for (String panelName : panelNames) {
         JPanel panel = new JPanel();
         panel.setName(panelName);
         // panel.addMouseListener(mAdapter);
         // panel.addMouseMotionListener(mAdapter);
         panel.setBorder(BorderFactory.createTitledBorder(panelName));
         panel.add(Box.createRigidArea(new Dimension(300, 300)));
         add(panel);
      }
   }

   private class MyMouseAdapter extends MouseAdapter {
      @Override
      public void mousePressed(MouseEvent e) {
         displayInfo(e, "mousePressed");
      }

      @Override
      public void mouseReleased(MouseEvent e) {
         displayInfo(e, "mouseReleased");
      }

      @Override
      public void mouseDragged(MouseEvent e) {
         displayInfo(e, "mouseDragged");
      }

      private void displayInfo(MouseEvent e, String info) {
         JComponent comp = (JComponent) e.getSource();
         Component childComp = comp.getComponentAt(e.getPoint());
         if (childComp != null) {
            String name = childComp.getName();
            System.out.println(name + ": " + info);
         }
      }
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("TestMouseRelease");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new TestMouseRelease());
      frame.pack();
      frame.setLocationRelativeTo(null);
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