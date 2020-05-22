import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class LayeredFun extends JLayeredPane {
   private static final int JLP_WIDTH = 400;
   private static final int JLP_HEIGHT = 400;
   private static final Dimension PANEL_SIZE = new Dimension(200, 200);

   public LayeredFun() {
      JPanel defaultPanel = createPanel("Default Panel", new Point(10, 10), Color.cyan);
      JPanel palettePanel = createPanel("Palette Panel", new Point(100, 100), Color.pink);

      add(defaultPanel, JLayeredPane.DEFAULT_LAYER);
      add(palettePanel, JLayeredPane.PALETTE_LAYER);
   }

   private JPanel createPanel(String name, Point location, Color color) {
      JPanel defaultPanel = new JPanel();
      defaultPanel.setSize(PANEL_SIZE);
      defaultPanel.setLocation(location);
      MyMouseAdapter defaultMouseAdapater = new MyMouseAdapter(name);
      defaultPanel.addMouseListener(defaultMouseAdapater);
      defaultPanel.addMouseMotionListener(defaultMouseAdapater);
      defaultPanel.setBackground(color);
      defaultPanel.setBorder(BorderFactory.createTitledBorder(name));
      return defaultPanel;
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(JLP_WIDTH, JLP_HEIGHT);
   }

   private class MyMouseAdapter extends MouseAdapter {
      private String name;

      public MyMouseAdapter(String name) {
         this.name = name;
      }

      @Override
      public void mouseEntered(MouseEvent e) {
         System.out.printf("%s: mouseEntered%n", name);
      }

      @Override
      public void mouseExited(MouseEvent e) {
         System.out.printf("%s: mouseExited%n", name);
      }

      @Override
      public void mouseMoved(MouseEvent e) {
         System.out.printf("%s: mouseMoved%n", name);
      }
   }

   private static void createAndShowUI() {
      JFrame frame = new JFrame("LayeredFun");
      frame.getContentPane().add(new LayeredFun());
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            createAndShowUI();
         }
      });
   }
}